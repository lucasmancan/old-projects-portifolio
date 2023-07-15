package br.com.lucasmancan.security.exceptions;

public class AuthenticationNotFoundException extends RuntimeException {
    public AuthenticationNotFoundException(String message) {
        super(message);
    }

    public AuthenticationNotFoundException() {
        super("Usuário não autenticado.");
    }
}
