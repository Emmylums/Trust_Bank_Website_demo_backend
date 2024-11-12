package com.trustbank.repository;

import com.trustbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByAccountNumber(String accountNumber);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
    Optional<List<Customer>> findByBankVerificationNumber(String bankVerificationNumber);
}
