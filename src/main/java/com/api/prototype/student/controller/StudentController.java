package com.api.prototype.student.controller;


import com.api.prototype.student.entity.Student;
import com.api.prototype.student.service.StudentNotFoundException;
import com.api.prototype.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/v1/create")
    public Student postStudent(Student student) {
        return student;

    }

    @GetMapping("/v1/get")
    public List<Student> getListStudent() throws StudentNotFoundException {
        List<Student> students = service.getListStudent();
        return students;
    }

    @GetMapping("/v1/get/{studentId}")
    public Student getStudentOne(@PathVariable("studentId") Integer studentId) {
        Student student = service.getStudent(studentId);
        return student;
    }
}
