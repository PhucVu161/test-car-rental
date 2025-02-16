package com.example.test_login_react.controller;

import com.example.test_login_react.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.test_login_react.service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping()
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        List<Account> accounts = accountService.getAccounts();
        Optional<Account> user = accounts.stream()
                .filter(acc -> acc.getUsername().equals(username) && acc.getPassword().equals(password))
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
        Account user = (Account) session.getAttribute("user");
        if (user == null) {
            return Map.of("loggedIn", false);
        }
        return Map.of("loggedIn", true, "username", user.getUsername(), "role", user.getRole());
    }
}
