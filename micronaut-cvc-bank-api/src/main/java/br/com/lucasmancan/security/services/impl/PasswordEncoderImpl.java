package br.com.lucasmancan.security.services.impl;

import br.com.lucasmancan.security.services.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Singleton;

@Singleton
public class PasswordEncoderImpl implements PasswordEncoder {
    org.springframework.security.crypto.password.PasswordEncoder delegate = new BCryptPasswordEncoder();

    public String encode(String rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String hash) {
        return delegate.matches(rawPassword, hash);
    }
}
