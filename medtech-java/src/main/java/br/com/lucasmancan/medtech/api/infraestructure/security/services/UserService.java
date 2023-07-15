package br.com.lucasmancan.medtech.api.infraestructure.security.services;

import br.com.lucasmancan.medtech.api.domain.dto.NewPassword;
import br.com.lucasmancan.medtech.api.domain.dto.SignUpUser;
import br.com.lucasmancan.medtech.api.domain.dto.UserDTO;
import br.com.lucasmancan.medtech.api.domain.entities.User;

public interface UserService {

    User save(User entity);

    User findById(String id);

    void inactivate(String id);

    UserDTO findUserInfo();

    UserDTO update(UserDTO user);

    void verifyAccount(String token);

    UserDTO signUp(SignUpUser user);

    void verifyEmail(String email);

    void updatePassword(NewPassword password);
}
