package com.api.prototype.response;


import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginResponse {

    String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
