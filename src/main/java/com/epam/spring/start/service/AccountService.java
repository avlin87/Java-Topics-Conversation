package com.epam.spring.start.service;

import com.epam.spring.start.domain.entity.Account;
import com.epam.spring.start.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(new Account());
    }
}
