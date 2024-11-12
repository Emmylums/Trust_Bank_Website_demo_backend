package com.trustbank.services.impl;

import com.trustbank.dto.AddressDTO;
import com.trustbank.dto.Response;
import com.trustbank.exception.OurException;
import com.trustbank.model.Address;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import com.trustbank.repository.AddressRepository;
import com.trustbank.services.interfac.IAddressService;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Response addAddress(Address address) {
        Response response = new Response();
        try{
            if(addressRepository.findByCustomer(address.getCustomer()).isPresent() || addressRepository.findByAdmin(address.getAdmin()).isPresent()){
                if(address.getCustomer()!= null){
                    throw new OurException(String.format("Already Present %s %s", address.getCustomer().getFirstName(), address.getCustomer().getLastName()));
                }
                if(address.getAdmin()!= null){
                    throw new OurException(String.format("Already Present %s %s", address.getAdmin().getFirstName(), address.getAdmin().getLastName()));
                }
            }
            Address savedAddress = addressRepository.save(address);
            AddressDTO addressDTO = Utils.mapAddressEntityToAddressDTO(savedAddress);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAddress(addressDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Adding Address %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllAddresses() {
        Response response = new Response();
        try{
            List<Address> addresses = addressRepository.findAll();
            List<AddressDTO> addressDTOList = Utils.mapAddressListEntityToAddressListDTO(addresses);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAddressList(addressDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving The Addresses %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAddressByCustomer(Customer customer) {
        Response response = new Response();
        try{
            List<Address> addresses = addressRepository.findByCustomer(customer).orElseThrow(() -> new OurException("Address not found"));;
            List<AddressDTO> addressDTOList = Utils.mapAddressListEntityToAddressListDTO(addresses);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAddressList(addressDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Addresses %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAddressByAdmin(Admin admin) {
        Response response = new Response();
        try{
            List<Address> addresses = addressRepository.findByAdmin(admin).orElseThrow(() -> new OurException("Address not found"));;
            List<AddressDTO> addressDTOList = Utils.mapAddressListEntityToAddressListDTO(addresses);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAddressList(addressDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Addresses %s",e.getMessage()));
        }
        return response;
    }
}
