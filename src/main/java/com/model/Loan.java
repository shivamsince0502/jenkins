package com.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "loan_amount")
    private int loanAmount;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Basic
    @Column(name = "date_of_sanction")
    private java.sql.Date loanDate;
    @Column(name = "loan_duration")
    private int loanDuration;

    public int getLoanId() {
        return loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public User getUser() {
        return user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }


    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loan_id=" + loanId +
                ", loan_amount=" + loanAmount +
                ", user_id=" + user +
                ", loanDate=" + loanDate +
                ", loan_time=" + loanDuration +
                '}';
    }

    public Loan() {
    }

    public Loan(int loanAmount, Date loanDate, int loanDuration, User user) {
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.loanDuration = loanDuration;
        this.user = user;
    }

}

