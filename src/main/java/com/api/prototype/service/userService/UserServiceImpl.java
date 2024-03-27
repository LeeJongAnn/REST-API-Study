package com.api.prototype.service.userService;


import com.api.prototype.Exception.InvalidPassword;
import com.api.prototype.Exception.UserNotFoundException;
import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.response.UserResponse.UserResponse;
import com.api.prototype.service.Token;
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

    public Token login(String email, String password) throws InvalidPassword {

        User UserDB = userRepository.findByEmail(email);
        String userByEmailPassword = UserDB.getPassword();

        if (!passwordEncoder.matches(password, userByEmailPassword)) {
            throw new InvalidPassword("Password is not correct");
        }

        return Token.of(UserDB.getId(), 10L, "mySecretNumber");

    }


    @Override
    public List<User> getUserList() {

        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers;
    }

    @Override
    @Transactional
    public User create(User user) {

        String password = user.getPassword();
        String encode = passwordEncoder.encode(password);
        user.changePassword(encode);
        User saveUser = userRepository.save(user);
        return saveUser;

    }

    @Override
    public User updateUser(Integer id, UserResponse editUser) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found: " + id)
        );
        user.editUser(editUser.getUsername(),editUser.getPassword(),editUser.getEmail());
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
