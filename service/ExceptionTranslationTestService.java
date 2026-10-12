package com.bm.demo.service;

import com.bm.demo.entity.Account;
import com.bm.demo.repository.AccountRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionTranslationTestService {

    private final AccountRepository accountRepository;

    public ExceptionTranslationTestService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void testExceptionTranslation() {
        try {
            // 1. Save an account with ID 100
            accountRepository.save(new Account(100L, "Charlie", 3000.0));
            accountRepository.flush(); // Force database interaction

            // 2. Try to save another account with the EXACT SAME ID (100)
            // This forces a primary key constraint violation!
            accountRepository.save(new Account(100L, "Duplicate Charlie", 1000.0));
            accountRepository.flush();

        } catch (DataAccessException ex) {
            // Spring intercepts the raw SQL/Hibernate error and translates it 
            // into this clean runtime exception automatically because of @Repository!
            System.err.println(" SUCCESS: Caught Spring's Translated Exception!");
            System.err.println(" Exception Class: " + ex.getClass().getName());
            System.err.println(" Message: " + ex.getMessage());
        }
    }
}