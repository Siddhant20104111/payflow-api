package com.payflow.payflow_api.service;

import com.payflow.payflow_api.entity.User;
import com.payflow.payflow_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    // At startup Spring creates an object
    // of UserRepository and injects it
    // automatically into this service.

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User findByUpiId(String upiId){
        return userRepository.findByUpiId(upiId);
    }
}
