package com.api.prototype.student.controller;


import com.api.prototype.student.entity.Student;
import com.api.prototype.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/v1/create")
    public String postStudent(Student student) {

        return "Hello World";

    }

    @GetMapping("/v1/get")
    public Student getStudent(Student student) {


    }
}
