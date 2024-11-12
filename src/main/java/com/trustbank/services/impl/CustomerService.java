package com.trustbank.services.impl;

import com.trustbank.dto.CustomerDTO;
import com.trustbank.dto.Response;
import com.trustbank.exception.OurException;
import com.trustbank.model.Customer;
import com.trustbank.repository.CustomerRepository;
import com.trustbank.services.interfac.ICustomerService;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Response register(Customer customer) {
        Response response = new Response();
        try{
            if(customerRepository.existsByEmail(customer.getEmail())){
                throw new OurException(String.format("Customer with Account Number %s already exists.",customer.getAccountNumber()));
            }
            Customer savedCustomer = customerRepository.save(customer);
            CustomerDTO customerDTO = Utils.mapCustomerEntityToCustomerDTO(savedCustomer);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomer(customerDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred During Customer Registration %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllCustomers() {
        Response response = new Response();
        try{
            List<Customer> customers = customerRepository.findAll();
            List<CustomerDTO> customerDTOList = Utils.mapCustomerListEntityToCustomerListDTO(customers);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomerList(customerDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Customers %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCustomerByAccountNumber(String accountNumber) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new OurException("Customer Not found"));
            CustomerDTO customerDTO = Utils.mapCustomerEntityToCustomerDTO(customer);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomer(customerDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Customer %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCustomersByBVN(String bvn) {
        Response response = new Response();
        try{
            List<Customer> customer = customerRepository.findByBankVerificationNumber(bvn).orElseThrow(() -> new OurException("Customer Not found"));
            List<CustomerDTO> customerDTO = Utils.mapCustomerListEntityToCustomerListDTO(customer);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomerList(customerDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Customer %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCustomerInfo(String email) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new OurException("Customer Not found"));
            CustomerDTO customerDTO = Utils.mapCustomerEntityToCustomerDTO(customer);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomer(customerDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred while retrieving customer %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCustomerById(String id) {
        Response response = new Response();
        try{
            Customer customer = customerRepository.findById(Long.valueOf(id)).orElseThrow(() -> new OurException("Customer Not found"));
            CustomerDTO customerDTO = Utils.mapCustomerEntityToCustomerDTO(customer);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCustomer(customerDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred while Retrieving customer %s",e.getMessage()));
        }
        return response;
    }
}
