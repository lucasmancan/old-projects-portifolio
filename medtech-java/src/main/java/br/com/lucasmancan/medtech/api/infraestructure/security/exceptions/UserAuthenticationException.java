package br.com.lucasmancan.medtech.api.infraestructure.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserAuthenticationException extends RuntimeException {
    public UserAuthenticationException(String message) {
        super(message);
    }

    public UserAuthenticationException() {
        super("Erro de autenticação.");
    }
}
