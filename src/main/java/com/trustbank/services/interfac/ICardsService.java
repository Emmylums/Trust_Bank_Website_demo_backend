package com.trustbank.services.interfac;

import com.trustbank.enums.CARD_TYPE;
import com.trustbank.dto.Response;
import com.trustbank.model.Cards;
import com.trustbank.model.Customer;

import java.time.LocalDateTime;

public interface ICardsService {

    Response addCards(Cards cards);
    Response getAllCards();
    Response getCardsByCardNumber(String cardNumber);
    Response getCardsById(String id);
    Response getCardsByActivationPeriod(LocalDateTime startDate, LocalDateTime endDate);
    Response getCardsByExpirationPeriod(LocalDateTime startDate, LocalDateTime endDate);
    Response getCardsByActivationDate(LocalDateTime activationDate);
    Response getCardsByExpirationDate(LocalDateTime expirationDate);
    Response getCardsByCardType(CARD_TYPE cardType);
    Response getCardsByCustomer(Customer customer);
}
