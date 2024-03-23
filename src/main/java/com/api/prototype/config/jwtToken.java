package com.api.prototype.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

public class jwtToken {

    SecretKey key = Jwts.SIG.HS256.key().build();
    String jws = Jwts.builder().subject("Joe").signWith(key).compact();
}
