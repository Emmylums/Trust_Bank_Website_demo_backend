package com.trustbank.services.interfac;

import com.trustbank.dto.Response;
import com.trustbank.model.Admin;

public interface IAdminService {

    Response register(Admin admin);
    Response getAllAdmin();
    Response deleteAdmin(String email);
    Response getAdminByEmail(String email);
    Response getAdminByPhoneNumber(String phoneNumber);
    Response getAdminsByRole(String role);
    Response getAdminById(String adminId);
    Response getAdminInfo(String adminId);
}
