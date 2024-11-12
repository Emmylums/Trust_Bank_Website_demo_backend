package com.trustbank.dto;

import com.trustbank.model.Image;
import com.trustbank.model.Transactions;
import com.trustbank.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

    private String accountNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String maritalStatus;

    private Character gender;

    private Date dateOfBirth;

    private String localGovernmentArea;

    private String stateOfOrigin;

    private String nationality;

    private String email;

    private String phoneNumber;

    private Address address;

    private String bankVerificationNumber;

    private List<Image> verificationImages;

    private Double balance;

    private String accountCondition;

    private List<Transactions> transactionsDTOList = new ArrayList<>();

    public CustomerDTO(String accountNumber, String firstName, String middleName, String lastName, String maritalStatus, Character gender, Date dateOfBirth, String localGovernmentArea, String stateOfOrigin, String nationality, String email, String phoneNumber, Address address, String bankVerificationNumber, List<Image> verificationImages, Double balance, String accountCondition, List<Transactions> transactionsDTOList) {
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
        this.accountCondition = accountCondition;
        this.transactionsDTOList = transactionsDTOList;
    }
}
