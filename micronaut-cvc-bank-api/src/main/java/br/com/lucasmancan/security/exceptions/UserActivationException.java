package br.com.lucasmancan.security.exceptions;

public class UserActivationException extends RuntimeException {
    public UserActivationException() {
        super("Erro ao ativar conta, tente novamente mais tarde.");
    }
}
