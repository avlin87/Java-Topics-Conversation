package com.epam.annotations.service.impl;

import com.epam.annotations.service.AccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountServiceImpl implements AccountService {

    @Override
    public void deleteAccount(String id) {
        log.info("Account {} deleted!", id);
    }

    @Override
    public void viewAccount(String id) {
        log.info("Viewing account {}", id);
    }
}
