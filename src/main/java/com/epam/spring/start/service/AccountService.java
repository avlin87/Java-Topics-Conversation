package com.epam.spring.start.service;

import com.epam.spring.start.domain.entity.Account;
import com.epam.spring.start.exceptions.EntityNotFound;
import com.epam.spring.start.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFound(String.format("Account %s not found", id)));
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
