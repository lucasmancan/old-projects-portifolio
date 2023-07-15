package br.com.lucasmancan.security.exceptions;

public class PasswordDoenstMatchException extends RuntimeException {
    public PasswordDoenstMatchException(String s) {
        super(s);
    }
}
