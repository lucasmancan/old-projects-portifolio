package br.com.lucasmancan.services;

public interface PasswordEncoderService {
    String encode(String rawPassword);

    boolean equals(String rawPassword, String hash);
}
