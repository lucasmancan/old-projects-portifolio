package br.com.lucasmancan.medtech.api.infraestructure.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordDoenstMatchException extends RuntimeException {
    public PasswordDoenstMatchException(String s) {
        super(s);
    }
}
