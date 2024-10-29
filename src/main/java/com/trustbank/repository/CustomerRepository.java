package com.trustbank.repository;

import com.trustbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserId(Long userId);
    Customer findByAccountNumber(String accountNumber);
    Customer findByEmail(String email);
    Customer findByPhoneNumber(String phoneNumber);
    Customer findByBankVerificationNumber(String bankVerificationNumber);
}
