package br.com.lucasmancan.medtech.api.infraestructure.security.services.impl;

import br.com.lucasmancan.medtech.api.infraestructure.security.services.AuthWhiteListService;
import org.springframework.stereotype.Component;

@Component
public class AuthWhiteListServiceImpl implements AuthWhiteListService {
    @Override
    public String[] getAll() {
        return new String[]{
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/auth/**",
                "/console/**",
                "/h2-console/**",
                "/h2-console/*",
                "/h2-console/*",
                "/v1/accounts",
                "/users/signup",
                "/auth/**",
                "/public/**",
                "/users/verify-email/**",
                "/users/verify-account/**",
                "/users/reset-password/**", "/actuator/**"
        };
    }
}
