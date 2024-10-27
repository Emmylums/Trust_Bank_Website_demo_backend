package com.trustbank.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String nation,state,localGovernmentArea,houseDetails;

    @Override
    public String toString() {
        return "Address{" +
                houseDetails +
                localGovernmentArea +
                state +
                nation +
                '}';
    }
}
