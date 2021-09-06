package com.example.AccountManagementSystem.controller;

import com.example.AccountManagementSystem.model.Account;
import com.example.AccountManagementSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public List<Account> getAccounts(){

        return accountService.getAccounts();
    }

    @PostMapping("/")
    public boolean addAccount(@RequestBody Account account){
        if (!(accountService.isAccountExist(account.getAccountNumber()))){
            accountService.addAccount(account);
        }
        return true;
    }

    @DeleteMapping("/{accountNumber}")
    public boolean deleteAccount(@PathVariable("accountNumber") long accountNumber){
        if(accountService.isAccountExist(accountNumber)){
            accountService.deleteAccount(accountNumber);
        }
        return true;
    }

    @PostMapping("/{AccountNumber}")
    public double getAccountBalance(@PathVariable("AccountNumber") long accountNumber){
        return accountService.getAccountBalance(accountNumber);
    }

    @GetMapping("/{AccountNumber}")
    public boolean isAccountExist(@PathVariable("AccountNumber") long accountNumber){
        return accountService.isAccountExist(accountNumber);
    }
}
