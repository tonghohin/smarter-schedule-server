package com.smarterschedule.server.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student updateStudent(Student newStudent, Long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            student.setName(newStudent.getName());
            student.setPhone(newStudent.getPhone());
            student.setEmail(newStudent.getEmail());
            return studentRepository.save(student);
        }).orElseGet(() -> {
            return studentRepository.save(newStudent);
        });
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

}
