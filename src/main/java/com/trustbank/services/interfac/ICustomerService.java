package com.trustbank.services.interfac;

import com.trustbank.dto.Response;
import com.trustbank.model.Customer;

public interface ICustomerService {
    Response register(Customer customer);
    Response getAllCustomers();
    Response getCustomerByAccountNumber(String accountNumber);
    Response getCustomersByBVN(String bvn);
    Response getCustomerInfo(String email);
    Response getCustomerById(String id);
}
