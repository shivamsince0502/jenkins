package com.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_no")
    private int account_no;
    @Column(name = "acc_type")
    private String acc_type;

    @Column(name = "branch")
    private String branch;

    @Column(name = "balance")
    private int balance;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;



    public Account() {
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccount_no() {
        return account_no;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public String getBranch() {
        return branch;
    }

    public int getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_no=" + account_no +
                ", acc_type='" + acc_type + '\'' +
                ", branch='" + branch + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }


    public Account(int account_no, String acc_type, String branch, int balance, User user) {
        this.account_no = account_no;
        this.acc_type = acc_type;
        this.branch = branch;
        this.balance = balance;
        this.user = user;
    }
}
