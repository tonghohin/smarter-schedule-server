package com.smarterschedule.server.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByUserId(Long userId);

    List<Lesson> findByStudentId(Long studentId);

}
