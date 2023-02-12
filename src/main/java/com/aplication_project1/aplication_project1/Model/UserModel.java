package com.aplication_project1.aplication_project1.Model;

import com.aplication_project1.aplication_project1.Model.LessonModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String address;
    private boolean teacher;

    @ManyToMany
    private Set<LessonModel> lessons = new HashSet<>();

}



