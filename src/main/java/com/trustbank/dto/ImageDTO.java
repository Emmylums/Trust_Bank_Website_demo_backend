package com.trustbank.dto;

import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageDTO {

    private Long id;

    private String imageName;

    private byte[] imageData;

    private Customer customer;

    private Admin admin;

    @Override
    public String toString() {
        return String.join("/",imageName, Arrays.toString(imageData));
    }

    public boolean isACustomer(){
        return customer!=null;
    }

    public boolean isAnAdmin(){
        return admin!=null;
    }

    public ImageDTO(String imageName, byte[] imageData, Customer customer, Admin admin) {
        this.imageName = imageName;
        this.imageData = imageData;
        this.customer = customer;
        this.admin = admin;
    }
}
