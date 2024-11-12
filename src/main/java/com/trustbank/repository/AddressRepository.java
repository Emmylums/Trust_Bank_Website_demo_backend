package com.trustbank.repository;

import com.trustbank.model.Address;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<List<Address>> findByCustomer(Customer customer);
    Optional<List<Address>> findByAdmin(Admin admin);
}