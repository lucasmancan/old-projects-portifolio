package br.com.lucasmancan.exceptions;

public class AccountAlreadyExistsException extends ValidationException {
    public AccountAlreadyExistsException(String message) {
        super(message);
    }

    public AccountAlreadyExistsException() {
        super("Account is already in use.");
    }
}
