package com.example.AccountManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    public long accountNumber;
    public double balance;
    @OneToOne
    public User user;

    public Account() {
    }

    public Account(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(long accountNumber, double balance, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + accountNumber +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }
}
