package com.example.AccountManagementSystem.controller;

import com.example.AccountManagementSystem.model.Transaction;
import com.example.AccountManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transfer")
    public boolean transferMoney(@RequestBody Transaction transaction){

        return transactionService.transferMoney(transaction);

    }

    @PostMapping("/deposit")
    public boolean depositMoney(@RequestBody Transaction transaction){
        return transactionService.depositMoney(transaction);

    }

    @PostMapping("/withdraw")
    public boolean withdrawMoney(@RequestBody Transaction transaction){
        return transactionService.withdrawMoney(transaction);

    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionById(@PathVariable("accountNumber") long accountNumber){
        return transactionService.getTransactionsById(accountNumber);

    }

    @GetMapping("/")
    public List<Transaction> transactionHistory(){
        return transactionService.transactionHistory();
    }
}
