package com.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private int userId;

    @Column(name = "acc_holder_name")
    private String accHolderName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "mob_no")
    private int mobNo;


//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//    private Account account;
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JoinColumn
//    private List<Loan> loanList;
//
//    public List<Loan> getLoanList() {
//        return loanList;
//    }

//    public void setLoanList(List<Loan> loanList) {
//        this.loanList = loanList;
//    }

    public int getUserId() {
        return userId;
    }


    public String getAccHolderName() {
        return accHolderName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getMobNo() {
        return mobNo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobNo(int mobNo) {
        this.mobNo = mobNo;
    }

    @Override
    public String toString() {
        return "users{" +
                "user_id=" + userId +
                ", acc_holder_name='" + accHolderName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mob_no=" + mobNo +
                '}';
    }

    public User() {
    }

    public User(int userId, String accHolderName, String address, String email, int mobNo) {
        this.userId = userId;
        this.accHolderName = accHolderName;
        this.address = address;
        this.email = email;
        this.mobNo = mobNo;
    }
}
