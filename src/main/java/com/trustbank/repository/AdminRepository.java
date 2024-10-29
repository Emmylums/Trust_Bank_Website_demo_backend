package com.trustbank.repository;

import com.trustbank.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
    Admin findByPhoneNumber(String phoneNumber);
}
