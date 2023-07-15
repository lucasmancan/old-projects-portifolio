package br.com.lucasmancan.security.models;

import br.com.lucasmancan.entities.Account;
import io.micronaut.security.authentication.UserDetails;
import lombok.Getter;

import java.util.Collections;

@Getter
public class AccountDetails extends UserDetails {
    private final Account account;

    public AccountDetails(Account account) {
        super(account.getId().toString(), Collections.emptyList());
        this.account = account;
    }
}
