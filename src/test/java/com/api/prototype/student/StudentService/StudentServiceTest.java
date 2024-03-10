package com.api.prototype.student.StudentService;

import com.api.prototype.student.entity.Student;
import com.api.prototype.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;




@SpringBootTest
@Rollback(value = true)
public class StudentServiceTest {


    @Autowired
    private StudentService studentService;


    @Test
    public void createServiceTest() {

        Student student = new Student();
        student.setId(1);
        student.setName("홍길동");

        Student student1 = studentService.create(student);


        assertEquals(student1.getName(), "홍길동");



    }

    @Test
    public void getServiceTest() {

        Student student = new Student();
        student.setId(1);
        student.setName("홍길동");


        Student student2 = new Student();
        student.setId(2);
        student.setName("이박사");

        List<Student> students = studentService.get();


        assertEquals(2,students.stream().count());


    }
}
