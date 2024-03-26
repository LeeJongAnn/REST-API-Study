package com.api.prototype.service;

import com.api.prototype.entity.User;

import java.util.List;

public interface UserService {

    public User create(User user);

    public List<User> getUserList();

    public User updateUser(Integer id);


}
