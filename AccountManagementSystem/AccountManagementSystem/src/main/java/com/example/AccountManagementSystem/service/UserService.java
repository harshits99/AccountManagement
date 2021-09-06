package com.example.AccountManagementSystem.service;


import com.example.AccountManagementSystem.model.Account;
import com.example.AccountManagementSystem.model.User;
import com.example.AccountManagementSystem.reporistory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public boolean addUser(User user){
        userRepo.save(user);
        return true;
    }

    public List<User> getUsers(){
        return (List<User>)userRepo.findAll();
    }

    public boolean updateUser(User user){
        userRepo.save(user);
        return true;
    }

    public boolean deleteUser(String username){
        userRepo.deleteById(username);
        return true;
    }

    public boolean isUserExist(User user){
        User other= new User("","");
        User user1=(User) userRepo.findById(user.getUsername()).orElse(other);
        System.out.println(user.getPassword() + user1.getPassword());
        if (user1.getPassword().equals(user.getPassword()))
            return true;
        return false;
    }

    public boolean isUserValid(String username){
        return userRepo.existsById(username);
    }
}
