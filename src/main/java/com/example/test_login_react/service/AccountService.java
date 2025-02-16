package com.example.test_login_react.service;

import com.example.test_login_react.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test_login_react.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
