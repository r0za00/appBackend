package com.aplication_project1.aplication_project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
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

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel checkUserExist(UserModel user) {
        UserModel user1 = userRepository.findUserByLogin(user.getLogin());
        if(user1.getPassword().equals(user.getPassword())){
            return user1;
        }
        return null;
    }
}
