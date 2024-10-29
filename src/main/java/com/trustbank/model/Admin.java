package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String  adminRole;

    private String address;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Image passport;

    @OneToOne
    @JoinColumn(name = "meansOfVerification_id")
    private Image meansOfVerification;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return String.format("Admin { id= %s, First Name= %s," +
                        "Middle Name= %s, Last Name= %s, Email= %s, " +
                        "Phone Number= %s, Address= %s, Admin Role= %s,  User= %s }",
                id, firstName,middleName, lastName, email,
                phoneNumber, address, adminRole, user);
    }
}
