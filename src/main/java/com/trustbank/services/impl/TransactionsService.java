package com.trustbank.services.impl;

import com.trustbank.dto.Response;
import com.trustbank.dto.TransactionsDTO;
import com.trustbank.enums.TRANSACTION_TYPE;
import com.trustbank.exception.OurException;
import com.trustbank.model.Customer;
import com.trustbank.model.Transactions;
import com.trustbank.repository.CustomerRepository;
import com.trustbank.repository.TransactionsRepository;
import com.trustbank.services.interfac.ITransactionsService;
import com.trustbank.utils.JWTUtils;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsService implements ITransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public Response saveTransaction(Transactions transactions) {
        Response response = new Response();
        try{
            Transactions savedTransactions = transactionsRepository.save(transactions);
            TransactionsDTO transactionsDTO = Utils.mapTransactionsEntityToTransactionsDTO(savedTransactions);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactions(transactionsDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Saving Transaction %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllTransactions() {
        Response response = new Response();
        try{
            List<Transactions> transactionsList = transactionsRepository.findAll();
            List<TransactionsDTO> transactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(transactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(transactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionsByCustomer(String accountNumber) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new OurException("Customer Not found"));
            List<Transactions> customersSenderTransactionsList = transactionsRepository.findBySenderId(String.valueOf(customer.getId())).orElseThrow(()-> new OurException("Transactions Not Found"));
            List<Transactions> customersReceiverTransactionsList = transactionsRepository.findByReceiverId(String.valueOf(customer.getId())).orElseThrow(()-> new OurException("Transactions Not Found"));

            List<Transactions> customerTransactionsList = new ArrayList<>();
            customerTransactionsList.addAll(customersSenderTransactionsList);
            customerTransactionsList.addAll(customersReceiverTransactionsList);

            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customerTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionsBySender(String accountNumber) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new OurException("Customer Not found"));
            List<Transactions> customersSenderTransactionsList = transactionsRepository.findBySenderId(String.valueOf(customer.getId())).orElseThrow(()-> new OurException("Transactions Not Found"));

            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customersSenderTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionsByReceiver(String accountNumber) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new OurException("Customer Not found"));
            List<Transactions> customersReceiverTransactionsList = transactionsRepository.findByReceiverId(String.valueOf(customer.getId())).orElseThrow(()-> new OurException("Transactions Not Found"));

            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customersReceiverTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionByCustomerWithinPeriod(String accountNumber, LocalDateTime startDate, LocalDateTime endDate) {
        Response response = new Response();

        try{
            Customer customer = customerRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new OurException("Customer Not found"));
            List<Transactions> customerTransactionsList = transactionsRepository.findTransactionsByPeriodWithCustomer(String.valueOf(customer.getId()), startDate, endDate).orElseThrow(()-> new OurException("No transactions found within the period"));
            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customerTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionWithinPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        Response response = new Response();

        try{
            List<Transactions> customerTransactionsList = transactionsRepository.findTransactionsByPeriod(startDate, endDate).orElseThrow(()-> new OurException("No transactions found within the period"));
            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customerTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionById(String transactionId) {
        Response response = new Response();
        try{
            Transactions transactions = transactionsRepository.findById(Long.valueOf(transactionId)).orElseThrow(()-> new OurException("No transactions found"));
            if(transactions == null) throw new OurException("Couldn't find transactions");

            TransactionsDTO transactionsDTO = Utils.mapTransactionsEntityToTransactionsDTO(transactions);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactions(transactionsDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transaction %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getTransactionByTransactionType(TRANSACTION_TYPE transactionType) {
        Response response = new Response();

        try{
            List<Transactions> customerTransactionsList = transactionsRepository.findByTransactionType(String.format("%s",transactionType)).orElseThrow(()-> new OurException("No transactions found "));
            List<TransactionsDTO> customerTransactionsDTOList = Utils.mapTransactionsListEntityToTransactionsListDTO(customerTransactionsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setTransactionsList(customerTransactionsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Transactions %s",e.getMessage()));
        }
        return response;
    }
}
