package com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "transaction_amount")
    private int transactionAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user_id")
    private User fromUser;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @Basic
    @Column(name = "time_of_transaction")
    private java.sql.Date transactionDate;

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }


    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Transaction(int transactionAmount, User fromUser, User toUser, Date transactionDate) {
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}
