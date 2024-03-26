package com.api.prototype.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginRequest {

    String email;
    String password;


    @Builder
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }




}
