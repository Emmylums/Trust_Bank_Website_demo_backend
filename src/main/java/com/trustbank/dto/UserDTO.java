package com.trustbank.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    private CustomerDTO customerDTO;

    private AdminDTO adminDTO;

    @Override
    public String toString() {
        return username;
    }
}
