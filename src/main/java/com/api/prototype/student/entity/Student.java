package com.api.prototype.student.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "student")
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String grade;

    private String number;

    public Student() {

    }
    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}
