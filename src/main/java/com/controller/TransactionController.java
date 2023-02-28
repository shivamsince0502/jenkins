package com.controller;


import com.model.Transaction;
import com.services.TransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getAllTransactions")
    public List<Transaction> getAllTransactions() {
        logger.info("All Transactions");
        return transactionService.getAllTransactions();
    }


    @PostMapping("/sendMoney/{fromAccId}/{toAccId}/{amount}")
    public Transaction sendMoney(@PathVariable("amount") int amount,@PathVariable("fromAccId") int fromAccId,@PathVariable("toAccId") int toAccId){
        logger.info("transaction happened");
        return transactionService.sendMoney(amount, fromAccId, toAccId);
    }

    @GetMapping("/getAllTransactionsByUserId/{id}")
    public List<Transaction> getAllTransactionsOfUserById(@PathVariable("id") int id){
        logger.info("Transaction by a single user");
        return transactionService.getAllTransactionsOfUserById(id);
    }





}
