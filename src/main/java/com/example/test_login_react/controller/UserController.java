package com.example.test_login_react.controller;

import com.example.test_login_react.entity.User;
import com.example.test_login_react.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        List<User> accounts = userService.getUser();
        Optional<User> user = accounts.stream()
                .filter(acc -> acc.getEmail().equals(email) && acc.getPassword().equals(password))
                .findFirst();

        if (user.isPresent()) {
            session.setAttribute("user", user.get()); // Lưu vào Session
            return Map.of("success", true, "role", user.get().getRole());
        } else {
            return Map.of("success", false);
        }
    }

    @GetMapping("/logout")
    public Map<String, String> logout(HttpSession session) {
        session.invalidate(); // Xóa Session khi đăng xuất
        return Map.of("message", "Đăng xuất thành công!");
    }

    @GetMapping("/me")
    public Map<String, Object> getUserSession(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Map.of("loggedIn", false);
        }
        return Map.of("loggedIn", true, "email", user.getEmail(), "role", user.getRole());
    }
}
