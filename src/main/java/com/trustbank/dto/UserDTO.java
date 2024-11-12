package com.trustbank.dto;

import com.trustbank.enums.USER_ROLE;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private USER_ROLE role = USER_ROLE.CUSTOMER;

    private Customer customer;

    private Admin admin;

    public UserDTO(String username, USER_ROLE role, Customer customer, Admin admin){
        this.username = username;
        this.role = role;
        this.customer = customer;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return username;
    }
}
