package com.trustbank.dto;

import com.trustbank.enums.TRANSACTION_TYPE;
import com.trustbank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDTO {

    private Long id;

    private Double amount;

    private Date transactionDate;

    private TRANSACTION_TYPE transactionType = TRANSACTION_TYPE.TRANSFER;

    private Customer receiver;

    private Customer sender;

    public TransactionsDTO(Double amount, Date transactionDate, TRANSACTION_TYPE transactionType, Customer receiver, Customer sender) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.receiver = receiver;
        this.sender = sender;
    }
}
