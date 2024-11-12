package com.trustbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String CVV;

    @Column(nullable = false)
    private Date activationDate;

    @Column(nullable = false)
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable( name = "customer_cards", joinColumns = @JoinColumn(name = "cards_id"), inverseJoinColumns = @JoinColumn(name = "customer_id") )
    private Customer customer;

    public Cards(String cardType, String cardNumber, String CVV, Date activationDate, Date expirationDate, Customer customer) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.activationDate = activationDate;
        this.expirationDate = expirationDate;
        this.customer = customer;
    }
}
