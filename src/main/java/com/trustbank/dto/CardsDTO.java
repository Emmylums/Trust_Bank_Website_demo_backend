package com.trustbank.dto;

import com.trustbank.enums.CARD_TYPE;
import com.trustbank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsDTO {

    private Long id;

    private CARD_TYPE cardType;

    private String cardNumber;

    private String CVV;

    private Date activationDate;

    private Date expirationDate;

    private Customer customer;

    public CardsDTO(CARD_TYPE cardType, String cardNumber, String CVV, Date activationDate, Date expirationDate, Customer customer) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.activationDate = activationDate;
        this.expirationDate = expirationDate;
        this.customer = customer;
    }
}
