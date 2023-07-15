package br.com.lucasmancan.security.services;

import edu.umd.cs.findbugs.annotations.NonNull;

import javax.validation.constraints.NotBlank;

public interface PasswordEncoder {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}