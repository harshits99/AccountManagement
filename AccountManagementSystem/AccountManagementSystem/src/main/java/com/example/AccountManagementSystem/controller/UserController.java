package com.example.AccountManagementSystem.controller;


import com.example.AccountManagementSystem.model.Transaction;
import com.example.AccountManagementSystem.model.User;
import com.example.AccountManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @PostMapping("/")
    public boolean addUser(@RequestBody User input){
        if(!(userService.isUserExist(input))){
            userService.addUser(input);
        }
        return true;

    }

    @PutMapping("/")
    public boolean UpdateUser(@RequestBody User input){
        if (userService.isUserExist(input)){
            userService.updateUser(input);
        }
        return true;
    }

//    @DeleteMapping("/{username}")
//    public boolean deleteUser(@RequestBody){
//        if(userService.isUserExist(User))
//            userService.deleteUser(username);
//        return true;
//    }


    @PostMapping("/login")
    public boolean isUserExist(@RequestBody User user){

        return userService.isUserExist(user);
    }

    @PostMapping("/{username}")
    public boolean isUserValid(@PathVariable ("username") String username){
        return userService.isUserValid(username);
    }








}
