package br.com.lucasmancan.medtech.api.infraestructure.security.utils;

import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.AuthenticationNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AppSecurityContext {
    public String getCurrentAccountId() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return String.valueOf(authentication.getPrincipal());
        } catch (Exception e) {
            log.error("Account id is not set in the application context {0}", e);
            throw new AuthenticationNotFoundException();
        }
    }
}
