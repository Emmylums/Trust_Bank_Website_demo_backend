package com.trustbank.services.interfac;

import com.trustbank.dto.Response;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import com.trustbank.model.Image;

import java.util.List;

public interface IImageService {
    Response addImage(Image image);

    Response addImages(List<Image> images);

    Response getAllImages();
    Response getImagesByCustomer(Customer customer);
    Response getImagesByAdmin(Admin admin);
}
