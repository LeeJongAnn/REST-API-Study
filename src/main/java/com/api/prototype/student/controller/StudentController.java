package com.api.prototype.student.controller;


import com.api.prototype.student.entity.Student;
import com.api.prototype.student.response.StudentDTO;
import com.api.prototype.student.service.StudentNotFoundException;
import com.api.prototype.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/v1/create")
    public StudentDTO postStudent(Student student) {

        StudentDTO studentDTO = new StudentDTO(student);

        return studentDTO;

    }

    @GetMapping("/v1/get")
    public List<Student> getListStudent() throws StudentNotFoundException {
        List<Student> students = service.getListStudent();
        return students;
    }

    @GetMapping("/v1/get/{studentId}")
    public Student getStudentOne(@PathVariable("studentId") Integer studentId) throws StudentNotFoundException {
        Student student = service.getStudent(studentId);
        return student;
    }

    @DeleteMapping("/v1/delete/{studentId}")
    public ResponseEntity<?> deleteStudentOne(@PathVariable("studentId") Integer studentId) throws StudentNotFoundException {

        service.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }
}
