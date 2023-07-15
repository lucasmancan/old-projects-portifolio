package br.com.lucasmancan.medtech.api.infraestructure.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("O E-mail informado não está disponível.");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
