package br.com.lucasmancan.medtech.api.infraestructure.security.services.impl;

import br.com.lucasmancan.medtech.api.configurations.EnvConfig;
import br.com.lucasmancan.medtech.api.configurations.email.services.EmailService;
import br.com.lucasmancan.medtech.api.domain.dto.NewPassword;
import br.com.lucasmancan.medtech.api.domain.dto.SignUpUser;
import br.com.lucasmancan.medtech.api.domain.dto.UserDTO;
import br.com.lucasmancan.medtech.api.domain.entities.Status;
import br.com.lucasmancan.medtech.api.domain.entities.Token;
import br.com.lucasmancan.medtech.api.domain.entities.User;
import br.com.lucasmancan.medtech.api.domain.exceptions.NotFoundException;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.TokenRepositorySD;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.UserRepositorySD;
import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.*;
import br.com.lucasmancan.medtech.api.infraestructure.security.services.JwtService;
import br.com.lucasmancan.medtech.api.infraestructure.security.services.UserService;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.AppSecurityContext;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.ParseUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositorySD repository;
    private final TokenRepositorySD tokenRepositorySD;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final EnvConfig envConfig;
    private final JwtService jwtService;
    private final AppSecurityContext appSecurityContext;


    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void inactivate(String id) {
        repository.deleteById(id);
    }

    public User findCurrent() {
        return repository.findById(appSecurityContext.getCurrentAccountId()).orElseThrow(UserAuthenticationException::new);
    }

    @Override
    public UserDTO findUserInfo() {
        var user = this.findCurrent();
        return new UserDTO(user.getName(), user.getPhone(), user.getEmail(), user.getDocument());
    }

    @Override
    public UserDTO update(UserDTO user) {
        var current = this.findCurrent();
        if (!current.getEmail().equals(user.getEmail()) && repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Não é possível utilizar esse e-mail.");
        }
        current.setPhone(user.getPhone());
        current.setEmail(user.getEmail());
        current.setName(user.getName());
        current.setDocument(user.getDocument());
        current = repository.save(current);
        return new UserDTO(current.getName(), current.getPhone(), current.getEmail(), user.getDocument());
    }

    @Override
    public void verifyAccount(String token) {
        var claims = jwtService.decode(token);
        String userId = claims.getBody().get("userId").toString();
        var user = repository.findById(userId).orElseThrow(UserActivationException::new);
        user.setStatus(Status.active);
        repository.save(user);
    }

    @Override
    public UserDTO signUp(SignUpUser dto) {
        dto.validar();

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        var user = new User();
        user.setName(dto.getName());
        user.setDocument(dto.getDocument());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setStatus(Status.inactive);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user = repository.save(user);

        String token = jwtService.generate(user, null);

        var map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("link", envConfig.getFrontUrl() + "auth/entrar?auth=" + token);

        emailService.sendTemplateMessage(user.getEmail(), "signup", map);

        return new UserDTO(user.getName(), user.getPhone(), user.getEmail(), user.getDocument());
    }

    @Override
    public void verifyEmail(String email) {
        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty()) return;

        final Token token = new Token();
        token.setUserId(user.get().getId());

        var map = new HashMap<String, Object>();
        map.put("name", user.get().getName());
        map.put("token", token.getTokenCode());

        emailService.sendTemplateMessage(email, "verify-email", map).thenAccept(mail -> {
            tokenRepositorySD.save(token);
        });
    }

    @Override
    public void updatePassword(NewPassword password) {
        Token token = tokenRepositorySD.findByTokenCode(password.getToken())
                .orElseThrow(InvalidTokenException::new);

        if (password.dismatch()) {
            throw new PasswordDoenstMatchException("Senha e confirmação de senha não conferem");
        }

        var user = findById(token.getUserId());
        user.setPassword(passwordEncoder.encode(password.getPassword()));
        repository.save(user);

        token.setStatus(Status.inactive);
        tokenRepositorySD.save(token);

        var map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("date", ParseUtils.parseDate(new Date()));

        emailService.sendTemplateMessage(user.getEmail(), "change-password", map);
    }
}
