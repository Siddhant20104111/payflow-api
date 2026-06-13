package com.payflow.payflow_api.service;

import com.payflow.payflow_api.entity.Transaction;
import com.payflow.payflow_api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    // At startup Spring creates an object
    // of UserRepository and injects it
    // automatically into this service.

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction sendMoney(Transaction transaction){

        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
