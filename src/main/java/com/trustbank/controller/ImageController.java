package com.trustbank.controller;

import com.trustbank.dto.Response;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import com.trustbank.model.Image;
import com.trustbank.repository.AdminRepository;
import com.trustbank.repository.CustomerRepository;
import com.trustbank.services.interfac.IAdminService;
import com.trustbank.services.interfac.ICustomerService;
import com.trustbank.services.interfac.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/upload")
    public ResponseEntity<Response> uploadImage(@RequestParam("passport") MultipartFile passport, @RequestParam("meansOfVerification") MultipartFile meansOfVerification, @RequestParam("person") String email) throws IOException {
        if (passport.isEmpty() && meansOfVerification.isEmpty() && email.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response());
        }

        Response response;
        Image createdPassport;
        Image createdMeansOfVerification;

        if(!adminRepository.existsByEmail(email) && !customerRepository.existsByEmail(email)){
            response = new Response();
            response.setMessage("Email not associated with any account");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        if(adminRepository.existsByEmail(email)){
            Admin admin = adminRepository.findByEmail(email).orElseThrow();
            createdPassport = new Image(passport.getOriginalFilename(), passport.getBytes(),null, admin);
            createdMeansOfVerification = new Image(meansOfVerification.getOriginalFilename(), meansOfVerification.getBytes(), null, admin);
            System.out.println(createdPassport);
            System.out.println(createdMeansOfVerification);
            List<Image> imagesList = new ArrayList<>();
            imagesList.add(createdPassport);
            imagesList.add(createdMeansOfVerification);
            response = imageService.addImages(imagesList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        if(customerRepository.existsByEmail(email)){
            Customer customer = customerRepository.findByEmail(email).orElseThrow();
            createdPassport = new Image(passport.getOriginalFilename(), passport.getBytes(),customer, null);
            createdMeansOfVerification = new Image(meansOfVerification.getOriginalFilename(), meansOfVerification.getBytes(), customer, null);
            List<Image> imagesList = new ArrayList<>();
            imagesList.add(createdPassport);
            imagesList.add(createdMeansOfVerification);
            response = imageService.addImages(imagesList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response());
    }
}
