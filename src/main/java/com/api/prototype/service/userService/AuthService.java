package com.api.prototype.service.userService;

import com.api.prototype.Exception.LoginInvalidException;
import com.api.prototype.entity.Session;
import com.api.prototype.entity.User;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.service.Login;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthService {


    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public String signin(Login login) {
        User user = userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow(LoginInvalidException::new);

        Session session = user.addSession();

        return session.getAccessToken();


    }
}
