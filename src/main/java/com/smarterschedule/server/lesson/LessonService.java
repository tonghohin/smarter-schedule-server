package com.smarterschedule.server.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson createOrUpdateLesson(Lesson newLesson) {
        return lessonRepository.save(newLesson);
    }

    public void deleteLesson(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    public List<Lesson> getLessonsByUserId(Long userId) {
        return lessonRepository.findByUserId(userId);
    }

    public List<Lesson> getLessonsByStudentId(Long studentId) {
        return lessonRepository.findByStudentId(studentId);
    }

}
