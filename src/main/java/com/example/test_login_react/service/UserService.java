package com.example.test_login_react.service;

import com.example.test_login_react.entity.User;
import com.example.test_login_react.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }
}
