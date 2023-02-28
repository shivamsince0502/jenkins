package com.services;

import com.model.Loan;
import com.model.User;
import com.model.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements  LoanService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Loan> getAllLoans() {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        List<Loan> loanList = session.createQuery("from Loan", Loan.class).list();
        transaction.commit();
        session.close();
        return loanList;
    }

    @Override
    public Loan takeLoan(int amount, int id, int duration) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        User user = session.get(User.class, id);
        Loan loan = new Loan(amount, date, duration, user);
        session.save(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    @Override
    public Loan updateLoanById(Loan loan) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    @Override
    public Loan deleteLoanById(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Loan loan = session.get(Loan.class, id);
        session.delete(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    @Override
    public Loan payInstallMent(int id, int installment) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Loan loan = session.get(Loan.class, id);
        loan.setLoanAmount(loan.getLoanAmount() - installment);
        session.saveOrUpdate(loan);
        transaction.commit();
        session.close();
        return loan;
    }

    @Override
    public User getUserFromLoanId(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Loan loan = session.get(Loan.class, id);
        User user = loan.getUser();
        return user;
    }



}
