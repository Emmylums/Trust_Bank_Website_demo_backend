package com.trustbank.services.interfac;

import com.trustbank.dto.Response;
import com.trustbank.enums.TRANSACTION_TYPE;
import com.trustbank.model.Transactions;

import java.time.LocalDateTime;

public interface ITransactionsService {
    Response saveTransaction(Transactions transactions);
    Response getAllTransactions();
    Response getTransactionsByCustomer(String accountNumber);
    Response getTransactionsBySender(String accountNumber);
    Response getTransactionsByReceiver(String accountNumber);
    Response getTransactionByCustomerWithinPeriod(String accountNumber, LocalDateTime startDate, LocalDateTime endDate);
    Response getTransactionWithinPeriod(LocalDateTime startDate, LocalDateTime endDate);
    Response getTransactionById(String transactionId);
    Response getTransactionByTransactionType(TRANSACTION_TYPE transactionType);
}
