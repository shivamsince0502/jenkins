package com.services;

import com.model.Account;
import com.model.Loan;
import com.model.Transaction;
import com.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(int id);
    User updateUser(User user);
    User deleteUser(int id);

//    List<Loan> getAllLoansOfUserById(int id);





}
