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

    private String address;

    private String bankVerificationNumber;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Image passport;

    @OneToOne
    @JoinColumn(name = "electricBill_id")
    private Image electricBill;

    @OneToOne
    @JoinColumn(name = "meansOfVerification_id")
    private Image meansOfVerification;

    private Double balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return String.format("Customer{ id= %s, accountNumber= %s, firstName= %s, " +
                        "middleName= %s, lastName= %s, email= %s, phoneNumber= %s," +
                        " address= %s, bankVerificationNumber= %s, balance= %.2f, user= %s }",
                id, accountNumber, firstName, middleName, lastName, email,
                phoneNumber, address, bankVerificationNumber, balance, user);
    }
}
