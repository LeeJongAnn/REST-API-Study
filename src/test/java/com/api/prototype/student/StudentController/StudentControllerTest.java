package com.api.prototype.student.StudentController;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void ControllerTest() throws Exception {

        mockMvc.perform(post("/v1/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id","1")
                        .param("name","홍길동"))
                .andExpect(status().isOk())
                .andDo(print());

    }

}
