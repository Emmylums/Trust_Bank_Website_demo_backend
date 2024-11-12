package com.trustbank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private String message;
    private String token;
    private String role;
    private String expirationDate;

    private String jwt;

    private UserDTO user;
    private CustomerDTO customer;
    private CardsDTO cards;
    private AdminDTO admin;
    private TransactionsDTO transactions;
    private ImageDTO image;
    private AddressDTO address;

    private List<UserDTO> userList;
    private List<CustomerDTO> customerList;
    private List<AdminDTO> adminList;
    private List<CardsDTO> cardsList;
    private List<TransactionsDTO> transactionsList;
    private List<ImageDTO> imageList;
    private List<AddressDTO> addressList;
}
