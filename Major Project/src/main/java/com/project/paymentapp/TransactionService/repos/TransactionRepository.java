package com.project.paymentapp.TransactionService.repos;

import com.project.paymentapp.TransactionService.entites.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {
    Optional<Transaction> findByTxId(String txId);
}
