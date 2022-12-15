package com.aplication_project1.aplication_project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImplementation {
    @Autowired
    private LessonRepository lessonRepository;

    public void saveLesson(LessonModel user) {
        lessonRepository.save(user);
    }

    public List<LessonModel> getAllLesson() {
        return lessonRepository.findAll();
    }
}
