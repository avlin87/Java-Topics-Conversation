package com.epam.spring.start.controller;

import com.epam.spring.start.domain.entity.Account;
import com.epam.spring.start.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id) {
        return accountService.findById(id);
    }

    @GetMapping
    public List<Account> getAccount() {
        return accountService.findAll();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }
}
