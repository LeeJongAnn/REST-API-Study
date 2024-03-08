package com.api.prototype.student.controller;


import com.api.prototype.student.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {


    @PostMapping("/v1/create")
    public String postStudent(Student student) {

        return "Hello World";

    }
}
