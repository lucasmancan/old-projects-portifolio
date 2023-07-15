package br.com.lucasmancan.security.services;

import br.com.lucasmancan.entities.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface JwtService {
    String generate(Account user);

    Jws<Claims> decode(String token);
}