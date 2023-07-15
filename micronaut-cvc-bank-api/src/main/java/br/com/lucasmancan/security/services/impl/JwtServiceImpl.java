package br.com.lucasmancan.security.services.impl;

import br.com.lucasmancan.entities.Account;
import br.com.lucasmancan.security.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Singleton
public class JwtServiceImpl implements JwtService {

    @Value("micronaut.security.token.jwt.signatures.secret.generator.secret")
    private String secret;

    public String generate(Account account) {
        Date expirationDate = Date.from(LocalDateTime.now().plusSeconds(300)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setSubject(account.getNumber())
                .claim("accountId", account.getId())
                .setExpiration(expirationDate)
                .compact();
    }

    public Jws<Claims> decode(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""));
    }
}
