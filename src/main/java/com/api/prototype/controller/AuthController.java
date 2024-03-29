package com.api.prototype.controller;


import com.api.prototype.response.SessionResponse;
import com.api.prototype.service.Login;
import com.api.prototype.service.userService.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Base64;

@RestController
@Slf4j
public class AuthController {


    private final AuthService authService;
    private static final String KEY = "1OUusVd9qt7aerP2flB+I8JmEh7yTYz3X3mFlPRamzo=";


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public SessionResponse login(@RequestBody Login login) {

        String accessToken = authService.signin(login);

        SecretKey key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(KEY));
//        log.info(">>{}", strkey);

        String jws = Jwts.builder().subject("Joe").signWith(key).compact();
        return new SessionResponse(jws);


    }
}

