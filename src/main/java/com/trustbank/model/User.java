package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Admin admin;

    @Override
    public String toString() {
        return username;
    }
}
