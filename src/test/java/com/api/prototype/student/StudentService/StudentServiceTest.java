package com.api.prototype.student.StudentService;

import com.api.prototype.student.entity.Student;
import com.api.prototype.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class StudentServiceTest {


    @Autowired
    private StudentService studentService;

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
