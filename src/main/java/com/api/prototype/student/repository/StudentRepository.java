package com.api.prototype.student.repository;

import com.api.prototype.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
