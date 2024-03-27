package com.api.prototype.service.userService;

import com.api.prototype.Exception.UserNotFoundException;
import com.api.prototype.entity.User;
import com.api.prototype.response.UserResponse.UserResponse;

import java.util.List;

public interface UserService {

    public User create(User user);

    public List<User> getUserList();

    public User updateUser(Integer id, UserResponse editUser) throws UserNotFoundException;

    public void deleteUser(Integer id) throws UserNotFoundException;


}
