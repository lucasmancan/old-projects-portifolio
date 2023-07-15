package br.com.lucasmancan.security.exceptions;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException() {
        super("Token inválido");
    }
}
