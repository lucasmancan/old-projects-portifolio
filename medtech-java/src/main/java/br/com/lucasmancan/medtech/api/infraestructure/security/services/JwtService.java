package br.com.lucasmancan.medtech.api.infraestructure.security.services;

import br.com.lucasmancan.medtech.api.domain.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.time.LocalDateTime;

public interface JwtService {
    String generate(User user, LocalDateTime expiresAt);

    Jws<Claims> decode(String token);
}
