package com.trustbank.services.impl;

import com.trustbank.dto.AdminDTO;
import com.trustbank.dto.Response;
import com.trustbank.enums.ADMIN_ROLE;
import com.trustbank.exception.OurException;
import com.trustbank.model.Admin;
import com.trustbank.repository.AdminRepository;
import com.trustbank.services.interfac.IAdminService;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminRepository adminRepository;


    @Override
    public Response register(Admin admin) {
        Response response = new Response();
        try{
            if(adminRepository.existsByEmail(admin.getEmail())){
                throw new OurException(String.format("Admin %s %s already exists. Please contact Management",admin.getFirstName(), admin.getLastName()));
            }
            boolean isNotEnumValue = true;
            for (ADMIN_ROLE a : ADMIN_ROLE.values()) {
                if (admin.getAdminRole().equalsIgnoreCase(a.name())) {
                    isNotEnumValue = false;
                    break;
                }
            }

            if (isNotEnumValue) {
                throw new OurException("Please contact management");
            }
            Admin savedAdmin = adminRepository.save(admin);
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(savedAdmin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred During Admin Registration %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllAdmin() {
        Response response = new Response();
        try{
            List<Admin> admins = adminRepository.findAll();
            List<AdminDTO> adminDTO = Utils.mapAdminListEntityToAdminListDTO(admins);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdminList(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving The Admins %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response deleteAdmin(String email) {
        Response response = new Response();
        try{
            Admin admin = adminRepository.findByEmail(email).orElseThrow(() -> new OurException("User not found"));
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(admin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error occurred while deleting Admin %s", e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAdminByEmail(String email) {
        Response response = new Response();
        try{
            Admin admin = adminRepository.findByEmail(email).orElseThrow(() -> new OurException("Admin not found"));
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(admin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error occurred while retrieving Admin %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAdminByPhoneNumber(String phoneNumber) {
        Response response = new Response();
        try{
            Admin admin = adminRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new OurException("Admin not found"));
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(admin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error occurred while retrieving Admin %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAdminsByRole(String role) {
        Response response = new Response();
        try{
            List<Admin> admins = adminRepository.findByAdminRole(role).orElseThrow(() -> new OurException("Admins not found"));;
            List<AdminDTO> adminDTO = Utils.mapAdminListEntityToAdminListDTO(admins);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdminList(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Admins %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAdminById(String id) {
        Response response = new Response();
        try{
            Admin admin = adminRepository.findById(Long.valueOf(id)).orElseThrow(() -> new OurException("Admin not found"));
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(admin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error occurred while retrieving Admin %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAdminInfo(String adminId) {
        Response response = new Response();
        try{
            Admin admin = adminRepository.findById(Long.valueOf(adminId)).orElseThrow(() -> new OurException("Admin not found"));
            AdminDTO adminDTO = Utils.mapAdminEntityToAdminDTO(admin);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setAdmin(adminDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error occurred while retrieving Admin %s",e.getMessage()));
        }
        return response;
    }
}
