package com.trustbank.repository;

import com.trustbank.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByImageName(String imageName);
    Image findByImageData(byte[] imageData);
    Image findByCustomerId(Long customerId);
    Image findByAdminId(Long adminId);
}
