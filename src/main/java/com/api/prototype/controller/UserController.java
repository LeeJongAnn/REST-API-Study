package com.api.prototype.controller;


import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.response.UserResponse;
import com.api.prototype.service.UserService;
import com.api.prototype.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/api/listUsers")
    public List<User> getUserList() {

        List<User> userList = new ArrayList<>();

        List<User> allUsers = (List<User>) userRepository.findAll();

        return allUsers;
    }

    @PostMapping("/api/createUser")
    public UserResponse createUser(@RequestBody User user) {

        User saveUser = userService.create(user);

        UserResponse userResponse = new UserResponse().responseDTO(saveUser);

        return userResponse;

    }



}
