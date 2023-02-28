package com.services;

import com.model.Loan;
import com.model.User;

import java.util.List;

public interface LoanService {
    List<Loan> getAllLoans();
    User getUserFromLoanId(int id);

    Loan takeLoan(int amount, int id, int time);

    Loan updateLoanById(Loan loan);

    Loan deleteLoanById(int id);

    Loan payInstallMent(int id, int installment);


}
