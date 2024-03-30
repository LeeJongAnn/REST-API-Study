package com.api.prototype.service.userService;


import com.api.prototype.Exception.UserNotFoundException;
import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.request.UserSignUpRequest;
import com.api.prototype.response.UserResponse.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> getUserList() {

        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers;
    }

    @Transactional
    public User create(UserSignUpRequest userSignUpRequest) {
        String password = userSignUpRequest.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        User user = new User().builder()
                .email(userSignUpRequest.getEmail())
                .username(userSignUpRequest.getUsername())
                .password(encodePassword)
                .build();

        boolean matches = passwordEncoder.matches(password, encodePassword);
        System.out.println(matches);
        return userRepository.save(user);

    }


    @Override
    public User updateUser(Integer id, UserResponse editUser) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found: " + id)
        );
        user.editUser(editUser.getUsername(), editUser.getPassword(), editUser.getEmail());
        String encodedPassword = passwordEncoder.encode(editUser.getPassword());
        user.changePassword(encodedPassword);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found: " + id)
        );

        userRepository.delete(user);

    }
}
