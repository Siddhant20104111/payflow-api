package com.payflow.payflow_api.controller;

import com.payflow.payflow_api.entity.User;
import com.payflow.payflow_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/upi/{upiId}")
    public  User getUserByUpi(@PathVariable String upiId){
        return userService.findByUpiId(upiId);
    }


    @PostMapping("/test")
    public User test(User user){
        System.out.println(user);
        return user;
    }



}
