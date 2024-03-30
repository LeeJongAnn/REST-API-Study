package com.api.prototype.service.userService;

import com.api.prototype.Exception.LoginInvalidException;
import com.api.prototype.entity.Session;
import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.service.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class AuthService {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String signin(Login login) {
        User user = userRepository.findByEmail(login.getEmail());


        System.out.println(login.getPassword());
        System.out.println(user.getPassword());
        Session session = user.addSession();

        if(!passwordEncoder.matches(login.getPassword(), user.getPassword())){
             throw new LoginInvalidException();
        }

        return session.getAccessToken();


    }
}
