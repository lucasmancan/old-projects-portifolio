package br.com.lucasmancan.medtech.api.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException {

    public InternalException() {
    }

    public InternalException(String message) {
        super(message);
    }
}
