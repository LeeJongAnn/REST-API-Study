package com.api.prototype.controller;

import com.api.prototype.Exception.InvalidPassword;
import com.api.prototype.response.LoginRequest;
import com.api.prototype.response.LoginResponse;
import com.api.prototype.service.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private UserServiceImpl userService;



    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws InvalidPassword {


        var token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        return new LoginResponse(token.getToken());
    }

}
