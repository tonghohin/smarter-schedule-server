package com.smarterschedule.server.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByUserId(Long userId) {
        return studentRepository.findByUserId(userId);
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student updateStudent(Student newStudent) {
        return studentRepository.save(newStudent);

    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

}
