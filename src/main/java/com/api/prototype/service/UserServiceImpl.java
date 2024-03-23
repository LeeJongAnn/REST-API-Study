package com.api.prototype.service;


import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public User create(User user) {

        User saveUser = userRepository.save(user);
        return saveUser;

    }


}
