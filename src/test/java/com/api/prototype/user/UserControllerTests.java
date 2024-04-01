package com.api.prototype.user;


//import com.api.prototype.config.SecurityConfiguration;

import com.api.prototype.config.SecurityConfiguration;
import com.api.prototype.controller.UserController;
import com.api.prototype.entity.User;
import com.api.prototype.service.userService.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@WebMvcTest(controllers = UserController.class ,
//        excludeAutoConfiguration = SecurityAutoConfiguration.class, // 추가
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfiguration.class)})
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;


    @MockBean
    private Mockito mockito;


    @Test
    @DisplayName("유저 객체에 대한 테스트")
    public void userGetListTest() throws Exception {

//        List<User> collect = IntStream.range(0, 100).mapToObj(i -> new User().builder().id(i)
//                .username("azaz" + i).password("asas" + i).email("qwer@gmail.com" + i)
//                .build()).collect(Collectors.toList());
        User user = new User()
                .builder()
                .id(1)
                .username("JJ" + 1)
                .email("JJ@naver.com" + 1)
                .password("asdf1234" + 1)
                .build();

        List<User> ListUser = List.of(user);

        Mockito.when(userService.getUserList()).thenReturn(ListUser);

        mockMvc.perform(get("/api/listUsers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }

}
