package com.trustbank.repository;

import com.trustbank.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<List<Image>> findByCustomer(Customer customer);
    Optional<List<Image>> findByAdmin(Admin admin);
}