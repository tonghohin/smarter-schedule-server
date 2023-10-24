package com.smarterschedule.server.lesson;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smarterschedule.server.student.Student;
import com.smarterschedule.server.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Column(name = "lesson_id")
    private @Id @GeneratedValue Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "from_time", nullable = false)
    private LocalTime from;

    @Column(name = "to_time", nullable = false)
    private LocalTime to;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, updatable = false)
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @JsonIgnore
    private User user;
}
