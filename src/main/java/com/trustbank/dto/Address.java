package com.trustbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String nation,state,localGovernmentArea,street, houseDetails;

    @Override
    public String toString() {
        return String.format("Address { %s, %s, %s, %s, %s }", houseDetails, street,
                localGovernmentArea, state, nation);
    }
}
