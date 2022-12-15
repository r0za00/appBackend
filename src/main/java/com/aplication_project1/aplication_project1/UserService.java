package com.aplication_project1.aplication_project1;

import java.util.List;

public interface UserService {
    public UserModel saveUser(UserModel user);
    public List<UserModel> getAllUsers();
    void deleteUser(int id);
    public UserModel checkUserExist(UserModel user);
}
