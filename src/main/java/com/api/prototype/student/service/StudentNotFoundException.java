package com.api.prototype.student.service;

public class StudentNotFoundException extends Exception {


    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
