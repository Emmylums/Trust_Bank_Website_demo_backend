package com.trustbank.services.impl;

import com.trustbank.dto.ImageDTO;
import com.trustbank.dto.Response;
import com.trustbank.exception.OurException;
import com.trustbank.model.Admin;
import com.trustbank.model.Customer;
import com.trustbank.model.Image;
import com.trustbank.repository.ImageRepository;
import com.trustbank.services.interfac.IImageService;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService{

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Response addImage(Image image) {
        Response response = new Response();
        try{
//            if(imageRepository.findByCustomer(image.getCustomer()).isPresent() || imageRepository.findByAdmin(image.getAdmin()).isPresent()){
//                if(image.getCustomer()!= null){
//                    throw new OurException(String.format("Already Present %s %s", image.getCustomer().getFirstName(), image.getCustomer().getLastName()));
//                }
//                if(image.getAdmin()!= null){
//                    throw new OurException(String.format("Already Present %s %s", image.getAdmin().getFirstName(), image.getAdmin().getLastName()));
//                }
//            }
            Image savedImage = imageRepository.save(image);
            ImageDTO imageDTO = Utils.mapImageEntityToImageDTO(savedImage);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setImage(imageDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Adding Image %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response addImages(List<Image> images) {
        Response response = new Response();
        try{
            List<Image> savedImages = imageRepository.saveAll(images);
            List<ImageDTO> imageDTOList = Utils.mapImageListEntityToImageListDTO(savedImages);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setImageList(imageDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Adding Image %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllImages() {
        Response response = new Response();
        try{
            List<Image> images = imageRepository.findAll();
            List<ImageDTO> imageDTOList = Utils.mapImageListEntityToImageListDTO(images);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setImageList(imageDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving The Images %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getImagesByCustomer(Customer customer) {
        Response response = new Response();
        try{
            List<Image> images = imageRepository.findByCustomer(customer).orElseThrow(() -> new OurException("Images not found"));;
            List<ImageDTO> imageDTOList = Utils.mapImageListEntityToImageListDTO(images);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setImageList(imageDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Images %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getImagesByAdmin(Admin admin) {
        Response response = new Response();
        try{
            List<Image> images = imageRepository.findByAdmin(admin).orElseThrow(() -> new OurException("Images not found"));;
            List<ImageDTO> imageDTOList = Utils.mapImageListEntityToImageListDTO(images);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setImageList(imageDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Images %s",e.getMessage()));
        }
        return response;
    }
}
