package com.trustbank.repository;

import com.trustbank.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmail(String email);
    Optional<Admin> findByEmail(String email);
    Optional<List<Admin>> findByAdminRole(String role);
    Optional<Admin> findByPhoneNumber(String phoneNumber);
}
