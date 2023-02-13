package com.aplication_project1.aplication_project1.Controller;

import com.aplication_project1.aplication_project1.Model.LessonModel;
import com.aplication_project1.aplication_project1.Model.UserModel;
import com.aplication_project1.aplication_project1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
        public String add(@RequestBody UserModel user){
        UserModel user1 = userService.saveUser(user);
        if(user1 == null) {
            return "Login exist";
        } else {
            return "New user added";
        }
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/checkUser")
    public ResponseEntity<?> checkUser(@RequestBody UserModel user){
        UserModel user1 = userService.checkUserExist(user);
        if(user1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(user1,HttpStatus.OK);
        }
    }

    @GetMapping("/getUserOrTeachers/{teacher}")
    public List<UserModel> getUsers(@PathVariable boolean teacher){
        return userService.getUsersOrTeachers(teacher);
    }

}
