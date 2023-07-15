package br.com.lucasmancan.medtech.api.infraestructure.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserActivationException extends RuntimeException {
    public UserActivationException() {
        super("Erro ao ativar conta, tente novamente mais tarde.");
    }
}
