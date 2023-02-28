package com.services;


import com.model.Loan;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        List<User> userList = session.createQuery("from User", User.class).list();
        transaction.commit();
        session.close();
        System.out.println("size : " +  userList.size());
        return userList;
    }

    @Override
    public User createUser(User user) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User updateUser(User user) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User deleteUser(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
        return user;
    }

//    @Override
//    public List<Loan> getAllLoansOfUserById(int id) {
//        Session session = sessionFactory.openSession();
//        org.hibernate.Transaction transaction = session.beginTransaction();
//        User user = session.get(User.class, id);
//        return user.getLoanList();
//    }


}
