package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String accountNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @Embedded
    private Address address;

    @Embedded
    private BankVerificationNumber bankVerificationNumber;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Image passport;

    @OneToOne
    @JoinColumn(name = "electricBill_id")
    private Image electricBill;

    @OneToOne
    @JoinColumn(name = "meansOfVerification_id")
    private Image meansOfVerification;

    private Long balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return "Customer{" +
                "id= " + id +
                ", accountNumber= '" + accountNumber +
                "', firstName= '" + firstName +
                "', middleName= '" + middleName +
                "', lastName= '" + lastName +
                ", email= '" + email +
                "', phoneNumber= '" + phoneNumber +
                ", address= '" + address +
                "', bankVerificationNumber= " + bankVerificationNumber +
                ", electricBill= " + electricBill +
                ", meansOfVerification= " + meansOfVerification +
                ", balance= " + balance +
                ", user= " + user +
                '}';
    }
}
