package com.trustbank.repository;

import com.trustbank.model.Cards;
import com.trustbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CardsRepository extends JpaRepository<Cards, Long> {
    boolean existsByCardNumber(String cardNumber);
    Optional<Cards> findByCardNumber(String cardNumber);
    Optional<List<Cards>> findByCardType(String cardType);
    Optional<List<Cards>> findByActivationDate(LocalDateTime activationDate);
    Optional<List<Cards>> findByExpirationDate(LocalDateTime expiration);
    Optional<List<Cards>> findByCustomer(Customer customer);
    @Query("SELECT e FROM Cards e WHERE e.activationDate BETWEEN :startDate AND :endDate")
    Optional<List<Cards>> findCardsByActivationPeriod(LocalDateTime startDate, LocalDateTime endDate);
    @Query("SELECT e FROM Cards e WHERE e.expirationDate BETWEEN :startDate AND :endDate")
    Optional<List<Cards>> findCardsByExpirationPeriod(LocalDateTime startDate, LocalDateTime endDate);
}