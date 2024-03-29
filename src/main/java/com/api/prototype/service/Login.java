package com.api.prototype.service;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Login {

    private final String email;
    private final String password;


    @Builder
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
