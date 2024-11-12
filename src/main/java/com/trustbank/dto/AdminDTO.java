package com.trustbank.dto;

import com.trustbank.enums.ADMIN_ROLE;
import com.trustbank.model.Address;
import com.trustbank.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private Long id;

    private String title;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private ADMIN_ROLE adminRole;

    private Address address;

    private List<Image> verificationImages;

    public AdminDTO(String title, String firstName, String middleName, String lastName, String email, String phoneNumber, ADMIN_ROLE adminRole, Address address, List<Image> verificationImages) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adminRole = adminRole;
        this.address = address;
        this.verificationImages = verificationImages;
    }
}
