package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "UniqueCustomerCredentials", columnNames =
        {"phoneNumber","email","passport","meansOfVerification","accountNumber"})})
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private Character gender;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String localGovernmentArea;

    @Column(nullable = false)
    private String stateOfOrigin;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(mappedBy = "customer")
    private Address address;

    @Column(nullable = false)
    private String bankVerificationNumber;

    @OneToMany(mappedBy = "customer")
    private List<Image> verificationImages = new ArrayList<>();

    @Column(nullable = false)
    private Double balance;

    @OneToMany
    private List<Transactions> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Cards> cards = new ArrayList<>();

    @Column(nullable = false)
    private String accountCondition;

    @OneToOne
    @JoinTable( name = "user_customer", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "user_id") )
    private User user;

    public Customer(String accountNumber, String firstName, String middleName, String lastName, String maritalStatus, Character gender, Date dateOfBirth, String localGovernmentArea, String stateOfOrigin, String nationality, String email, String phoneNumber, Address address, String bankVerificationNumber, List<Image> verificationImages, Double balance, List<Transactions> transactions, List<Cards> cards, String accountCondition, User user) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.localGovernmentArea = localGovernmentArea;
        this.stateOfOrigin = stateOfOrigin;
        this.nationality = nationality;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bankVerificationNumber = bankVerificationNumber;
        this.verificationImages = verificationImages;
        this.balance = balance;
        this.transactions = transactions;
        this.cards = cards;
        this.accountCondition = accountCondition;
        this.user = user;
    }
}