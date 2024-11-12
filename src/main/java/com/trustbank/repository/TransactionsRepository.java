package com.trustbank.repository;

import com.trustbank.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    @Query("SELECT e FROM Transactions e WHERE e.sender = :senderId")
    Optional<List<Transactions>> findBySenderId(String senderId);

    @Query("SELECT e FROM Transactions e WHERE e.receiver = :receiverId")
    Optional<List<Transactions>> findByReceiverId(String receiverId);

    Optional<List<Transactions>> findByTransactionDate(LocalDateTime date);

    Optional<List<Transactions>> findByTransactionType(String transactionType);

    @Query("SELECT e FROM Transactions e WHERE e.transactionDate BETWEEN :startDate AND :endDate")
    Optional<List<Transactions>> findTransactionsByPeriod(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT e FROM Transactions e WHERE e.sender = :customerId AND e.transactionDate BETWEEN :startDate AND :endDate")
    Optional<List<Transactions>> findTransactionsByPeriodWithCustomer(String customerId, LocalDateTime startDate, LocalDateTime endDate);
}
