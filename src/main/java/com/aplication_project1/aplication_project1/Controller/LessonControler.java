package com.aplication_project1.aplication_project1.Controller;

import com.aplication_project1.aplication_project1.Model.LessonModel;
import com.aplication_project1.aplication_project1.Model.UserModel;
import com.aplication_project1.aplication_project1.Service.LessonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lesson")
@CrossOrigin
public class LessonControler {
    @Autowired
    private LessonServiceImplementation lessonService;

    @PostMapping("/add")
    public String add(@RequestBody LessonModel lesson, UserModel user){
        lessonService.saveLesson(lesson, user);
        return "New lesson is added";
    }
    @GetMapping("/getAll")
    public List<LessonModel> getAllUsers(){
        return lessonService.getAllLesson();
    }

    @GetMapping("/getUser/{userId}")
    public List<LessonModel> getUserLesson(@PathVariable long userId){
        return lessonService.getUserLesson(userId);
    }

    @GetMapping("/getTeacher/{teacherId}")
    public List<LessonModel> getTeacherLesson(@PathVariable long teacherId){
        return lessonService.getTeacherLesson(teacherId);
    }
    @GetMapping("/getLesson/{id}")
    public List<LessonModel> getLessonById(@PathVariable long id){
        return lessonService.getLessonById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLesson(@PathVariable long id) {
        lessonService.deleteLesson(id);
    }
}
