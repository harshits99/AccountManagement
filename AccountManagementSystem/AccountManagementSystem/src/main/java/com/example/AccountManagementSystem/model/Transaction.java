package com.example.AccountManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long transactionID;
    public double amount;
    @ManyToOne
    public Account primaryAccount;
    @ManyToOne
    public Account receiverAccount;

    public Transaction() {
    }

    public Transaction(long transactionID, double amount, Account primaryAccount, Account receiverAccount) {
        transactionID = transactionID;
        this.amount = amount;
        this.primaryAccount = primaryAccount;
        this.receiverAccount = receiverAccount;
    }

    public Transaction(double amount, Account primaryAccount) {
        this.amount = amount;
        this.primaryAccount = primaryAccount;
    }

    public Transaction(double amount, Account primaryAccount, Account receiverAccount) {
        this.amount = amount;
        this.primaryAccount = primaryAccount;
        this.receiverAccount = receiverAccount;
    }
    
    

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(Account primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionID=" + transactionID +
                ", amount=" + amount +
                ", primaryAccount=" + primaryAccount +
                ", receiverAccount=" + receiverAccount +
                '}';
    }
}
