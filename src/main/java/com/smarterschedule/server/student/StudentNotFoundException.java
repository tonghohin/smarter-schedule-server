package com.smarterschedule.server.student;

public class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long studentId) {
        super("Could not find student with Student Id " + studentId);
    }

}
