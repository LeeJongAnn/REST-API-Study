package com.api.prototype.student.response;

import com.api.prototype.student.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {


    private Integer id;
    private String name;
    private String grade;
    private String number;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.grade = student.getGrade();
        this.number = student.getNumber();
    }


}
