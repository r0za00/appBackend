package com.aplication_project1.aplication_project1.Service;

import com.aplication_project1.aplication_project1.Model.UserModel;
import com.aplication_project1.aplication_project1.Repository.LessonRepository;
import com.aplication_project1.aplication_project1.Model.LessonModel;
import com.aplication_project1.aplication_project1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImplementation {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserRepository userRepository;

    public void saveLesson(LessonModel lessonModel, UserModel userModel) {
        userRepository.findById(lessonModel.getUserId());
        lessonRepository.save(lessonModel);
    }

    public List<LessonModel> getAllLesson() {
        return lessonRepository.findAll();
    }

    public List<LessonModel> getUserLesson(long id) {
        return lessonRepository.findLessonsByUserId(id);
    }

    public List<LessonModel> getTeacherLesson(long id) {
        return lessonRepository.findLessonsByTeacherId(id);
    }

    public void deleteLesson(long id) {
        lessonRepository.deleteById(id);
    }
}
