package com.controller;

import com.model.Loan;
import com.model.User;
import com.services.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    LoanService loanService;

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
    @GetMapping
    public List<Loan> getAllLoans() {
        logger.info("Loans List");
        return loanService.getAllLoans();
    }

    @PostMapping("/{amount}/{id}/{duration}")
    public Loan takeLoan(@PathVariable("amount") int amount, @PathVariable("id") int id, @PathVariable("duration") int duration){
        logger.info("Loan taken by" + id + " of " + amount);
        return loanService.takeLoan(amount, id, duration);
    }

    @PutMapping("/update")
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoanById(loan);
    }

    @DeleteMapping("/delete/{id}")
    public Loan deleteLoan(@PathVariable("id") int id) {
        return loanService.deleteLoanById(id);
    }

    @PutMapping("/payInstallment/{id}/{installment}")
    public Loan payInstallMent(@PathVariable("id") int id, @PathVariable("installment") int installment){
        return loanService.payInstallMent(id, installment);

    }

    @GetMapping("/getUserFromLoanId/{id}")
    public User getUserFromLoanId(@PathVariable("id") int id) {
        return loanService.getUserFromLoanId(id);
    }


}

