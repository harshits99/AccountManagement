package com.example.AccountManagementSystem.service;

import com.example.AccountManagementSystem.model.Account;
import com.example.AccountManagementSystem.model.Transaction;
import com.example.AccountManagementSystem.reporistory.AccountRepo;
import com.example.AccountManagementSystem.reporistory.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    AccountRepo accountRepo;

    public List<Transaction> getTransactionsById(long accountNumber){
        Account account = new Account(accountNumber);
        List<Transaction> primaryTransactions =new ArrayList<Transaction>();
        primaryTransactions.addAll((List<Transaction>)transactionRepo.findByPrimaryAccount(account));
        primaryTransactions.addAll((List<Transaction>)transactionRepo.findByReceiverAccount(account));
        System.out.println(primaryTransactions);
        return (primaryTransactions);
    }


    public boolean transferMoney(Transaction transaction){
        double amount=transaction.getAmount();
        if(amount<0) return false;
        Account sender=transaction.getPrimaryAccount();
        Account receiver=transaction.getReceiverAccount();
        if(sender.getAccountNumber() == receiver.getAccountNumber()) return false;
        Account acc1=(Account) accountRepo.findById(sender.getAccountNumber()).orElseThrow();
        Account acc2=(Account) accountRepo.findById(receiver.getAccountNumber()).orElseThrow();
        acc1.setBalance(acc1.getBalance()-amount);
        accountRepo.save(acc1);
        acc2.setBalance(acc2.getBalance()+amount);
        accountRepo.save(acc2);
        transactionRepo.save(new Transaction(amount,acc1,acc2));
        return true;
    }



    public boolean depositMoney(Transaction transaction){
        double amount=transaction.getAmount();
        if(amount<0) return false;
        Account primaryAccount=transaction.getPrimaryAccount();
        Account acc1=(Account) accountRepo.findById(primaryAccount.getAccountNumber()).orElseThrow();
        acc1.setBalance(acc1.getBalance()+amount);
        accountRepo.save(acc1);
        transactionRepo.save(new Transaction(amount,acc1));
        return true;
    }





    public boolean withdrawMoney(Transaction transaction){
        double amount=transaction.getAmount();
    if(amount<0) return false;
    Account primaryAccount=transaction.getPrimaryAccount();
    Account acc1 = (Account) accountRepo.findById(primaryAccount.getAccountNumber()).orElseThrow();
    if(acc1.getBalance()>=amount){
        acc1.setBalance(acc1.getBalance()-amount);
        accountRepo.save(acc1);
        transactionRepo.save(new Transaction(0-amount,acc1));
        return true;
    }
    return false;
    }

    public List<Transaction> transactionHistory(){
        return (List<Transaction>) transactionRepo.findAll();
    }


}
