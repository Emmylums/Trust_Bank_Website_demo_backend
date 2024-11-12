package com.trustbank.dto;

import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String houseDetails;

    private String street;

    private String localGovernmentArea;

    private String state;

    private String nation;

    private Customer customer;

    private Admin admin;

    @Override
    public String toString() {
        return String.join("/",houseDetails,street,localGovernmentArea,state,nation);
    }

    public AddressDTO(String houseDetails, String street, String localGovernmentArea, String state, String nation, Customer customer, Admin admin) {
        this.houseDetails = houseDetails;
        this.street = street;
        this.localGovernmentArea = localGovernmentArea;
        this.state = state;
        this.nation = nation;
        this.customer = customer;
        this.admin = admin;
    }
}
