package com.services;


import com.model.Account;
import com.model.Transaction;
import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Transaction> getAllTransactions() {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        List<Transaction> transactionList = session.createQuery("from Transaction", Transaction.class).list();
        transaction.commit();
        session.close();
        return transactionList;
    }

    @Override
    public List<Transaction> getAllTransactionsOfUserById(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        Query query =  session.createQuery("from Transaction where fromUser = :usr");
        query.setParameter("usr", user);
        List<Transaction> transactionList = query.getResultList();
        return transactionList;
    }

    @Override
    public Transaction sendMoney(int amount, int fromAccId, int toAccId) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Account fromAccount = session.get(Account.class, fromAccId);
        Account toAccount = session.get(Account.class, toAccId);
        int fromAmount = fromAccount.getBalance() - amount;
        int toAmount = toAccount.getBalance() + amount;
        fromAccount.setBalance(fromAmount);
        toAccount.setBalance(toAmount);
        session.saveOrUpdate(fromAccount);
        session.saveOrUpdate(toAccount);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        User fromUser = fromAccount.getUser();
        User toUser = toAccount.getUser();
        Transaction transaction1 = new Transaction(amount, fromUser, toUser, date);
        session.save(transaction1);
        transaction.commit();
        session.close();
        return transaction1;
    }
}
