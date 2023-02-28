package com.services;

import com.model.Account;
import com.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;



public interface TransactionService {

    List<Transaction> getAllTransactions();
    List<Transaction> getAllTransactionsOfUserById(int id);
    Transaction sendMoney(int amount, int fromId, int toId);
}
