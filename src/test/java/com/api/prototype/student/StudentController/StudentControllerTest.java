package com.api.prototype.student.StudentController;


import com.api.prototype.student.entity.Student;
import com.api.prototype.student.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void clean() {
        studentRepository.deleteAll();
    }

    @Test
    public void ControllerCreateTest() throws Exception {

        Student student = new Student();
        student.setName("나루토");

        String content = objectMapper.writeValueAsString(student);

        mockMvc.perform(post("/v1/create").content(content).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void ControllerGetTest() throws Exception {


        Student student = new Student();
        student.setName("김기사");



        Student student2 = new Student();
        student2.setName("김기사2");

        List<Student> studentList = studentRepository.saveAll(List.of(student, student2));

        mockMvc.perform(get("/v1/get").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("김기사"))
                .andDo(print());
        


    }


}
