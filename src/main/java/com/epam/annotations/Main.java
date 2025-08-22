package com.epam.annotations;

import com.epam.annotations.context.CurrentUser;
import com.epam.annotations.proxy.SecurityProxy;
import com.epam.annotations.service.AccountService;
import com.epam.annotations.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;

import static com.epam.annotations.enums.Role.ADMIN;
import static com.epam.annotations.enums.Role.USER;

@Slf4j
public class Main {

    public static void main(String[] args) {
        AccountService raw = new AccountServiceImpl();
        AccountService securedAccountService = SecurityProxy.secure(raw, AccountService.class);

        CurrentUser.loginWithRoles(USER);
        try {
            securedAccountService.deleteAccount("A-1");
        } catch (SecurityException e) {
            log.info(e.getMessage());
        }

        securedAccountService.viewAccount("A-1");

        CurrentUser.loginWithRoles(ADMIN);
        securedAccountService.deleteAccount("A-1");

        CurrentUser.clear();
    }
}
