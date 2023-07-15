package br.com.lucasmancan.controllers.v1;

import br.com.lucasmancan.dtos.AccountDTO;
import br.com.lucasmancan.dtos.CreateAccountDTO;
import br.com.lucasmancan.services.AccountService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;

@Controller("v1/accounts")
public class AccountController {

    @Inject
    AccountService accountService;


    @Post
    @Secured(SecurityRule.IS_ANONYMOUS)
    public AccountDTO create(@Body CreateAccountDTO accountDTO) {
        return accountService.create(accountDTO);
    }

    @Get
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public AccountDTO findActive() {
        return accountService.findActiveAccount();
    }
}
