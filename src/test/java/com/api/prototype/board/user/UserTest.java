package com.api.prototype.board.user;


import com.api.prototype.board.entity.User;
import com.api.prototype.board.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@Rollback(value = true)
public class UserTest {


    private UserRepository userRepository;

    @Autowired
    public UserTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void UserTest() {

        User user = new User()
                .builder()
                .id(1)
                .username("JJ")
                .email("JJ@naver.com")
                .password("asdf1234")
                .build();

        User saveUser = userRepository.save(user);

        Assertions.assertThat(saveUser.getUsername()).isEqualTo("JJ");

    }

}
