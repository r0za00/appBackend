package com.aplication_project1.aplication_project1;

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
        userService.saveUser(user);
        return "New user is added";
        }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value = "/user/{login}")
    public void deleteUser(@PathVariable int id) {
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
}
