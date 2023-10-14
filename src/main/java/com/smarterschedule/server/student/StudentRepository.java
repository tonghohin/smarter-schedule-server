package com.smarterschedule.server.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUserId(Long userId);
}
