package com.springReact.serverproductmanagement.service;

import com.springReact.serverproductmanagement.model.Transaction;
import com.springReact.serverproductmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Long numberOfTransaction() {
        return transactionRepository.count();
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
