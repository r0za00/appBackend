package com.aplication_project1.aplication_project1.Service;

import com.aplication_project1.aplication_project1.Model.UserModel;
import com.aplication_project1.aplication_project1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel checkUserExist(UserModel user) {
        UserModel user1 = userRepository.findUserByLogin(user.getLogin());
        if( user1 != null && user1.getPassword().equals(user.getPassword())){
            return user1;
        }
        return null;
    }
}
