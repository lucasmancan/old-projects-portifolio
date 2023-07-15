package br.com.lucasmancan.medtech.api.infraestructure.security.filters;

import br.com.lucasmancan.medtech.api.domain.entities.User;
import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.ValidationException;
import br.com.lucasmancan.medtech.api.infraestructure.security.models.Credentials;
import br.com.lucasmancan.medtech.api.infraestructure.security.models.UserDetailsImpl;
import br.com.lucasmancan.medtech.api.infraestructure.security.services.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public static final String AUTH_LOGIN_URL = "/auth";
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   JwtService jwtService, ObjectMapper objectMapper) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.objectMapper = objectMapper;
        setFilterProcessesUrl(AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) {
        try {
            var credentials = objectMapper.readValue(request.getInputStream(),
                    Credentials.class);

            var token = new UsernamePasswordAuthenticationToken(credentials.getEmail(),
                    credentials.getPassword(),
                    Collections.emptyList());

            return this.authenticationManager.authenticate(token);
        } catch (IOException e) {
            throw new ValidationException("Invalid request.");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication authentication) {

        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        String token = jwtService.generate(user, LocalDateTime.now().plusMinutes(30));
        response.addHeader("Authorization", String.format("Bearer %s", token));
        response.addHeader("access-control-expose-headers", "Authorization");
    }
}