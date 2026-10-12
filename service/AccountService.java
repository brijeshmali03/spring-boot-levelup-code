package com.bm.demo.service;

import com.bm.demo.entity.Account;
import com.bm.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Transactional configuration:
    // - propagation = REQUIRED: Joins an active transaction or starts a new one.
    // - isolation = READ_COMMITTED: Prevents dirty reads.
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void performTransfer() {
        // Save sample data
        accountRepository.save(new Account(1L, "Alice", 1000.0));
        accountRepository.save(new Account(2L, "Bob", 500.0));

        System.out.println("Accounts initialized successfully within a transaction!");
    }
}