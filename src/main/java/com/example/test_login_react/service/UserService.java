package com.example.test_login_react.service;

import com.example.test_login_react.entity.ApiResponse;
import com.example.test_login_react.entity.User;
import com.example.test_login_react.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public ApiResponse loginUser(String email, String password, HttpSession session) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);

        if (user.isPresent()) {
            session.setAttribute("user", user.get());
            return new ApiResponse(true, "Đăng nhập thành công", Map.of("role", user.get().getRole()));
        }
        return new ApiResponse(false, "Sai email hoặc mật khẩu", null);
    }

    public ApiResponse logoutUser(HttpSession session) {
        session.invalidate();
        return new ApiResponse(true, "Đăng xuất thành công", null);
    }

    public ApiResponse getUserSession(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ApiResponse(false, "Chưa đăng nhập", null);
        }
        return new ApiResponse(true, "Thông tin người dùng", Map.of("email", user.getEmail(), "role", user.getRole()));
    }
}
