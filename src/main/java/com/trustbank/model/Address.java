package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseDetails;

    private String street;

    private String localGovernmentArea;

    private String state;

    private String nation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable( name = "customer_address", joinColumns = @JoinColumn(name = "address_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable( name = "admin_address", joinColumns = @JoinColumn(name = "address_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"))
    private Admin admin;

    @Override
    public String toString() {
        return String.join("/",houseDetails,street,localGovernmentArea,state,nation);
    }

    public boolean isACustomer(){
        return customer!=null;
    }

    public boolean isAnAdmin(){
        return admin!=null;
    }

    public Address(String houseDetails, String street, String localGovernmentArea, String state, String nation, Customer customer, Admin admin) {
        this.houseDetails = houseDetails;
        this.street = street;
        this.localGovernmentArea = localGovernmentArea;
        this.state = state;
        this.nation = nation;
        this.customer = customer;
        this.admin = admin;
    }
}
