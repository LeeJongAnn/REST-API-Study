package com.api.prototype.controller;


import com.api.prototype.Exception.UserNotFoundException;
import com.api.prototype.config.UserSession;
import com.api.prototype.entity.User;
import com.api.prototype.response.UserResponse.UserResponse;
import com.api.prototype.service.userService.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/api/listUsers")
    public ResponseEntity<?> getUserList() {

        List<User> allUsers = userService.getUserList();

        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("/api/createUser")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {


        User saveUser = userService.create(user);

        UserResponse userResponse = new UserResponse().responseDTO(saveUser);

        return ResponseEntity.ok(userResponse);

    }

    @PutMapping("/api/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserResponse userResponse, @PathVariable("userId") Integer id) throws UserNotFoundException {
        User user = userService.updateUser(id, userResponse);

        UserResponse response = new UserResponse().responseDTO(user);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/api/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id) throws UserNotFoundException {

        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }


}
