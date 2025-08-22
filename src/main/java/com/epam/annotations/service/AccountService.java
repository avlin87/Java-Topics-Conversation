package com.epam.annotations.service;

import com.epam.annotations.annotation.RequiresRole;

import static com.epam.annotations.enums.Role.ADMIN;
import static com.epam.annotations.enums.Role.USER;

public interface AccountService {

    @RequiresRole(ADMIN)
    void deleteAccount(String id);

    @RequiresRole(USER)
    void viewAccount(String id);
}

