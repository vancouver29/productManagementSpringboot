package com.springReact.serverproductmanagement.repository;

import com.springReact.serverproductmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
