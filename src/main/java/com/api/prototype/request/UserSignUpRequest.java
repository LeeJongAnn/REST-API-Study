package com.api.prototype.request;


import lombok.Getter;

import java.util.Date;

@Getter
public class UserSignUpRequest {


    String email;

    String password;

    String username;

    Date creationTime;

    public UserSignUpRequest(String email, String password, String username, Date creationTime) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.creationTime = creationTime;
    }
}
