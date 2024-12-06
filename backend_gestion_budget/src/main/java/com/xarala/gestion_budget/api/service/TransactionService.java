package com.xarala.gestion_budget.api.service;

import com.xarala.gestion_budget.api.model.Transaction;
import com.xarala.gestion_budget.api.model.Transaction.TransactionType;
import com.xarala.gestion_budget.api.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction with ID " + id + " not found."));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cannot delete. Transaction with ID " + id + " not found.");
        }
        repository.deleteById(id);
    }

    public double calculateBalance() {
        List<Transaction> transactions = repository.findAll();
        return transactions.stream()
                .mapToDouble(transaction -> transaction.getType() == TransactionType.REVENU
                        ? transaction.getAmount()
                        : -transaction.getAmount())
                .sum();
    }
}
