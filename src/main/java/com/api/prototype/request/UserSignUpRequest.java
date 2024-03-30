package com.api.prototype.request;


import lombok.Getter;

@Getter
public class UserSignUpRequest {


    String email;

    String password;

    String username;

    String creationTime;

    public UserSignUpRequest(String email, String password, String username, String creationTime) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.creationTime = creationTime;
    }
}
