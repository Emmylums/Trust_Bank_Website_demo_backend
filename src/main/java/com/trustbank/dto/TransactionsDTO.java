package com.trustbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDTO {

    private Long id;

    private Double amount;

    private LocalDateTime transactionDate;

    private TransactionType transactionType = TransactionType.TRANSFER;

    private CustomerDTO receiver;

    private CustomerDTO sender;

    @Override
    public String toString() {
        return String.format("TransactionsDTO{ id= %s, amount= %s, " +
                        "transactionDate= %s, transactionType= %s, receiver= %s, " +
                        "sender= %s }",id,amount,transactionDate,transactionType,receiver,sender);
    }
}
