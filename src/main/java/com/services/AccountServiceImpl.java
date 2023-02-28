package com.services;

import com.model.Account;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Account> getAccounts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Account> accountList = session.createQuery("from Account", Account.class).list();
        transaction.commit();
        session.close();
        return  accountList;
    }

    @Override
    public Account createAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        return account;
    }

    @Override
    public Account getAccountById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        transaction.commit();
        session.close();
        return  account;
    }

    @Override
    public Account getAccountByUserId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        Query query =  session.createQuery("from Account as acc where acc.user = :usr");
        query.setParameter("usr", user);
        Account account = (Account) query.uniqueResult();
        transaction.commit();
        session.close();
        return  account;
    }

    @Override
    public Account updateAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
        return account;
    }

    @Override
    public Account deleteAccount(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        session.delete(account);
        transaction.commit();
        session.close();
        return account;
    }

    @Override
    public Account addMoneyToAccountById(int id, int money) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        account.setBalance(account.getBalance() + money);
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
        return  account;
    }
}
