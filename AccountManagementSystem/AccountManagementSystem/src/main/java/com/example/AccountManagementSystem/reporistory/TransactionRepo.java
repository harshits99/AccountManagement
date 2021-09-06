package com.example.AccountManagementSystem.reporistory;

import com.example.AccountManagementSystem.model.Account;
import com.example.AccountManagementSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    public List<Transaction> findByPrimaryAccount(Account account);
    public List<Transaction> findByReceiverAccount(Account account);


}