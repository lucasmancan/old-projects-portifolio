package br.com.lucasmancan.medtech.api.infraestructure.security.services.impl;


import br.com.lucasmancan.medtech.api.domain.entities.User;
import br.com.lucasmancan.medtech.api.infraestructure.security.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Component("jwtService")
public class JwtServiceImpl implements JwtService {

    @Value("jwt.secret")
    private String secret;

    public String generate(User user, LocalDateTime expiresAt) {
        var jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setSubject(user.getEmail())
                .claim("userId", user.getId());

        if (expiresAt != null) {
            jwt.setExpiration(Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant()));
        }

        return jwt.compact();
    }

    public Jws<Claims> decode(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""));
    }
}
