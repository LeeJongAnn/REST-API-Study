package com.api.prototype.student.StudentService;

import com.api.prototype.student.entity.Student;
import com.api.prototype.student.repository.StudentRepository;
import com.api.prototype.student.service.StudentNotFoundException;
import com.api.prototype.student.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceTest {


    @Autowired
    private StudentService studentService;


    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void clean() {
        studentRepository.deleteAll();
    }




    @Test
    @DisplayName("학생 생성 테스트")
    public void createServiceTest() {

        Student student = new Student();
        student.setName("홍길동");

        Student student1 = studentService.create(student);


        assertEquals("홍길동",student1.getName() );



    }

    @Test
    @DisplayName("학생 리스트 불러오기 테스트")
    public void getServiceTest() throws StudentNotFoundException {

        Student student = new Student();
        student.setName("이박사");

        Student student2 = new Student();
        student2.setName("김치전");


        studentRepository.saveAll(List.of(student, student2));

        List<Student> students = studentService.getListStudent();
        assertEquals(2, students.stream().count());


    }


}
