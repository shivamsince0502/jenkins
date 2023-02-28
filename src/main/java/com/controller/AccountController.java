package com.controller;

import com.model.Account;
import com.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/getAccounts")
    public List<Account> getAccount() {
        logger.info("All accounts");
        return accountService.getAccounts();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/getAccountById/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/getAccountByUserId/{id}")
    public Account getAccountByUserId(@PathVariable("id") int id) {
        return accountService.getAccountByUserId(id);
    }

    @PostMapping("/updateAccount")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public Account deleteAccount(@PathVariable("id") int id) {
        return accountService.deleteAccount(id);
    }

    @PostMapping("/addMoneyToAccount/{id}/{amount}")
    public Account addMoneyToAccountById(@PathVariable("id") int id, @PathVariable("amount") int amount){
        return accountService.addMoneyToAccountById(id, amount);
    }

}
