package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "UniqueAdminCredentials", columnNames = {"phoneNumber","email","passport","meansOfVerification"})})
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String adminRole;

    @OneToOne(mappedBy = "admin")
    private Address address;

    @OneToMany(mappedBy = "admin")
    private List<Image> verificationImages = new ArrayList<>();

    @OneToOne
    @JoinTable( name = "user_admin", joinColumns = @JoinColumn(name = "admin_id"), inverseJoinColumns = @JoinColumn(name = "user_id") )
    private User user;

    public Admin(String title, String firstName, String middleName, String lastName, String email, String phoneNumber, String adminRole, Address address, List<Image> verificationImages, User user) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adminRole = adminRole;
        this.address = address;
        this.verificationImages = verificationImages;
        this.user = user;
    }
}
