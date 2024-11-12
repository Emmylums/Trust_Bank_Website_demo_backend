package com.trustbank.services.interfac;

import com.trustbank.dto.LoginRequest;
import com.trustbank.dto.Response;
import com.trustbank.model.Customer;
import com.trustbank.model.User;

public interface IUserService {

    Response registerUser(User loginRequest);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response deleteUser(String username);
    Response getMyInfo(String username);
    Response getUserByCustomer(Customer customer);
}
