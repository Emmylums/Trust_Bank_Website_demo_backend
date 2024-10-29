package com.trustbank.repository;

import com.trustbank.model.Admin;
import com.trustbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByCustomerId(Long customerId);
    User findByAdminId(Admin adminId);
    boolean existsByUsername(String username);
}
