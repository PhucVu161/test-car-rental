package com.example.test_login_react.controller;

import com.example.test_login_react.entity.ApiResponse;
import com.example.test_login_react.entity.LoginRequest;
import com.example.test_login_react.entity.User;
import com.example.test_login_react.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getUser();
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword(), session);
    }

    @GetMapping("/logout")
    public ApiResponse logout(HttpSession session) {
        return userService.logoutUser(session);
    }

    @GetMapping("/me")
    public ApiResponse getUserSession(HttpSession session) {
        return userService.getUserSession(session);
    }
}
