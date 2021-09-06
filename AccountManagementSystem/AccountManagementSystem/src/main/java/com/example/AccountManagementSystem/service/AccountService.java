package com.example.AccountManagementSystem.service;

import com.example.AccountManagementSystem.model.Account;
import com.example.AccountManagementSystem.model.User;
import com.example.AccountManagementSystem.reporistory.AccountRepo;
import com.example.AccountManagementSystem.reporistory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    UserRepo userRepo;

    public boolean addAccount(Account account){
        accountRepo.save(account);
        return true;
    }

    public List<Account> getAccounts(){
        return (List<Account>) accountRepo.findAll();
    }

    public boolean deleteAccount(Long accountNumber){
        accountRepo.deleteById(accountNumber);
        return true;
    }

    public boolean isAccountExist(Long accountNumber){
        return accountRepo.existsById(accountNumber);
    }

    public double getAccountBalance(Long accountNumber){
        Account other = new Account();
        Account account = (Account) accountRepo.getById(accountNumber);
        double balance = account.getBalance();
        return balance;
    }

//    public boolean isAccountValid(String username){
//
//
//    }
}
