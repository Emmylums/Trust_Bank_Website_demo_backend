package com.trustbank.services.interfac;

import com.trustbank.dto.Response;
import com.trustbank.model.Address;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;

public interface IAddressService {
    Response addAddress(Address address);
    Response getAllAddresses();
    Response getAddressByCustomer(Customer customer);
    Response getAddressByAdmin(Admin admin);
}
