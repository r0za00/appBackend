package com.aplication_project1.aplication_project1;

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
    public String add(@RequestBody LessonModel lesson){
        lessonService.saveLesson(lesson);
        return "New user is added";
    }
    @GetMapping("/getAll")
    public List<LessonModel> getAllUsers(){
        return lessonService.getAllLesson();
    }
}
