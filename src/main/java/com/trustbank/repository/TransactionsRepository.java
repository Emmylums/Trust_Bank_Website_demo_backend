package com.trustbank.repository;

import com.trustbank.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findBySenderId(Long senderId);
    List<Transactions> findByReceiverId(Long receiverId);
    List<Transactions> findByTransactionDate(LocalDateTime date);
    List<Transactions> findByTransactionType(String transactionType);

    @Query("SELECT e FROM MyEntity e WHERE e.dateField BETWEEN :startDate AND :endDate")
    List<Transactions> findTransactionsByPeriod(LocalDateTime startDate, LocalDateTime endDate);
}
