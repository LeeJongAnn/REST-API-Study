package com.api.prototype.config;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


/*
* UserDetails를 구현한 User 구현체를 상속받아서
* 해당 내용들을 오버라이드 하여 사용한다.
* */

@Getter
public class UserDetailsImpl extends User {


    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
