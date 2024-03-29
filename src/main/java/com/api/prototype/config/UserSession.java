package com.api.prototype.config;


import lombok.Getter;

@Getter
public class UserSession {

    public final Long id;

    public UserSession(Long id) {
        this.id = id;
    }
}
