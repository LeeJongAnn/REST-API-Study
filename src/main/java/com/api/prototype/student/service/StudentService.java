package com.api.prototype.student.service;


import com.api.prototype.student.entity.Student;
import com.api.prototype.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getListStudent() throws StudentNotFoundException {
        List<Student> listStudent = studentRepository.findAll();
        if (listStudent.isEmpty()) {
            throw new StudentNotFoundException("학생들이 존재하지 않습니다.");
        }
        return listStudent;
    }



}
