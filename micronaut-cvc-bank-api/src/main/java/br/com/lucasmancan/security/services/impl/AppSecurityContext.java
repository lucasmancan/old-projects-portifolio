package br.com.lucasmancan.security.services.impl;

import br.com.lucasmancan.exceptions.AuthenticationException;
import br.com.lucasmancan.security.services.SecurityService;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;

@Singleton
@AllArgsConstructor
public class AppSecurityContext implements SecurityService {

    io.micronaut.security.utils.SecurityService securityService;

    @Override
    public Long getCurrentAccountId() {
        return securityService.getAuthentication()
                .map(authentication -> Long.parseLong(authentication.getName()))
                .orElseThrow(AuthenticationException::new);
    }
}
