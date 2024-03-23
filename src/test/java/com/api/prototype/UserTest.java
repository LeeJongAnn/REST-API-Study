package com.api.prototype;


import com.api.prototype.StudentApplication;
import com.api.prototype.repository.UserRepository;
import com.api.prototype.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = StudentApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class UserTest {


    private UserRepository userRepository;

    @Autowired
    public UserTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 생성 테스트")
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

    @Test
    @DisplayName("다수 유저 생성 테스트")
    public void test3() {
        int N = 10;

        List<User> listUser = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            User user = new User()
                    .builder()
                    .id(i)
                    .username("JJ" + i)
                    .email("JJ@naver.com" + i)
                    .password("asdf1234" + i)
                    .build();

            listUser.add(user);
        }

        userRepository.saveAll(listUser);


    }


}
