package com.example.test_login_react.controller;

import com.example.test_login_react.entity.Account;
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
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Map<String, Object> response = new HashMap<>();
        List<Account> accounts = accountService.getAccounts(); // Lấy danh sách account từ service

        Optional<Account> user = accounts.stream()
                .filter(acc -> acc.getUsername().equals(username) && acc.getPassword().equals(password))
                .findFirst();

        if (user.isPresent()) {
            response.put("success", true);
            response.put("role", user.get().getRole());
        } else {
            response.put("success", false);
        }
        return response;
    }
}
