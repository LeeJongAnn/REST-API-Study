package com.api.prototype.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.sqm.TemporalUnit;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
public class Token {

    private final String token;

    public Token(String token) {
        this.token = token;
    }

    static SecretKey key = Jwts.SIG.HS256.key().build();
    public static Token of(Integer userId, Long validityInMinutes, String secretKey) {

        var issueDate = Instant.now();
        return new Token(Jwts.builder()
                .claim("user_id", userId)
                .issuedAt(Date.from(issueDate))
                .expiration(Date.from(issueDate.plus(validityInMinutes, ChronoUnit.MINUTES)))
                .signWith(key)
                .compact());

    }
}
