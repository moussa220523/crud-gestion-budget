package com.xarala.gestion_budget.api.repository;

import com.xarala.gestion_budget.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
