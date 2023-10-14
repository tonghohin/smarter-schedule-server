package com.smarterschedule.server.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarterschedule.server.availability.Availability;
import com.smarterschedule.server.availability.AvailabilityService;
import com.smarterschedule.server.user.User;
import com.smarterschedule.server.user.UserService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @PostMapping("/{uid}")
    public Student createStudent(@RequestBody Student newStudent, @PathVariable String uid) {
        Student student = new Student(newStudent.getName(), newStudent.getPhone(), newStudent.getEmail());
        User user = userService.getUserByUid(uid);
        student.setUser(user);
        Student createdStudent = studentService.createOrUpdateStudent(student);
        List<Availability> availability = newStudent.getAvailability();
        availabilityService.createAvailability(createdStudent, availability);
        return createdStudent;
    }

    @GetMapping("/{uid}")
    public List<Student> getStudentsByUserId(@PathVariable String uid) {
        User user = userService.getUserByUid(uid);
        return studentService.getStudentsByUserId(user.getId());
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student newStudent) {
        return studentService.createOrUpdateStudent(newStudent);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

}
