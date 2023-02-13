package com.aplication_project1.aplication_project1.Service;

import com.aplication_project1.aplication_project1.Model.UserModel;

import java.util.List;

public interface UserService {
    public UserModel saveUser(UserModel user);
    public List<UserModel> getAllUsers();
    void deleteUser(long id);
    public UserModel checkUserExist(UserModel user);
    public List<UserModel> getUsersOrTeachers(boolean teacher);
}
