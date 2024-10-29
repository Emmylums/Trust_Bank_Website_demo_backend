package com.trustbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private ADMIN_ROLE adminRole = ADMIN_ROLE.ROLE_FRONT_DESK;

    private Address addressDTO;

    private ImageDTO passport;

    private ImageDTO meansOfVerification;

    private UserDTO userDTO;

    @Override
    public String toString() {
        return String.format("Admin { id= %s, First Name= %s," +
                        "Middle Name= %s, Last Name= %s, Email= %s, " +
                        "Phone Number= %s, Address= %s, Admin Role= %s  User= %s }",
                        id, firstName,middleName, lastName, email,
                        phoneNumber, addressDTO, adminRole, userDTO);
    }
}
