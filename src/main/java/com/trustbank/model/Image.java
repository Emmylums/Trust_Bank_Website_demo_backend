package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageName;

    @Lob @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable( name = "customer_image", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(name = "customer_id") )
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable( name = "admin_image ", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(name = "admin_id") )
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

    public Image(String imageName, byte[] imageData, Customer customer, Admin admin) {
        this.imageName = imageName;
        this.imageData = imageData;
        this.customer = customer;
        this.admin = admin;
    }
}
