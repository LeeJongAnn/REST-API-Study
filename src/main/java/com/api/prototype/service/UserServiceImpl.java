package com.api.prototype.service;


import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User user) {

        User save = userRepository.save(user);
        return save;

    }
}
