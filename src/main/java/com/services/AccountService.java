package com.services;

import com.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();
    Account createAccount(Account account);
    Account getAccountById(int id) ;
    Account getAccountByUserId(int id) ;
    Account updateAccount(Account account);
    Account deleteAccount(int id);

    Account addMoneyToAccountById(int id, int money);


}
