package br.com.lucasmancan.services.impl;

import br.com.lucasmancan.services.PasswordEncoderService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.inject.Singleton;

@Singleton
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

    org.springframework.security.crypto.password.PasswordEncoder delegate = new BCryptPasswordEncoder();

    public String encode(String rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean equals(String rawPassword, String hash) {
        return delegate.matches(rawPassword, hash);
    }
}

