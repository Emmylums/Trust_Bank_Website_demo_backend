package com.trustbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

    private String accountNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Address addressDTO;

    private String bankVerificationNumber;

    private ImageDTO passport;

    private ImageDTO electricBill;

    private ImageDTO meansOfVerification;

    private Double balance;

    private UserDTO userDTO;


    @Override
    public String toString() {
        return String.format("Customer{ id= %s, accountNumber= %s, firstName= %s, " +
                        "middleName= %s, lastName= %s, email= %s, phoneNumber= %s," +
                        " address= %s, bankVerificationNumber= %s, balance= %.2f, user= %s }",
                        id, accountNumber, firstName, middleName, lastName, email,
                        phoneNumber, addressDTO, bankVerificationNumber, balance, userDTO);
    }
}
