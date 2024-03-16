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

    /*
     * 학생 객체를 얻어온다.
     * parameter : id
     * author : LeeJongAnn
     * */

    public Student getStudent(Integer id) throws StudentNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("해당 하는 학생이 존재하지 않습니다."));
        return student;
    }

    /*
    * 학생 객체들에 대한 삭제를 요청한다.
    * parameter : id
    * author : LeeJongAnn
    * */
    public void deleteStudent(Integer id) throws  StudentNotFoundException {
        studentRepository.deleteById(id);
    }


}
