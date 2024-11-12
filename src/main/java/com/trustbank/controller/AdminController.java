package com.trustbank.controller;

import com.trustbank.dto.Response;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import com.trustbank.services.interfac.IAdminService;
import com.trustbank.services.interfac.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;


    @Autowired
    private ICustomerService customerService;



    @PostMapping("/addAdmin")
    @PreAuthorize("hasAuthority('BANK_MANAGER')")
    public ResponseEntity<Response> registerAdmin(@RequestBody Admin admin) throws IOException {
        System.out.println(admin);
        Response response = adminService.register(admin);
        System.out.println(response);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/addCustomer")
    @PreAuthorize("hasAuthority('ACCOUNT_MANAGER')")
    public ResponseEntity<Response> registerCustomer(@RequestBody Customer customer) throws IOException {
        System.out.println(customer);
        Response response = customerService.register(customer);
        System.out.println(response);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
