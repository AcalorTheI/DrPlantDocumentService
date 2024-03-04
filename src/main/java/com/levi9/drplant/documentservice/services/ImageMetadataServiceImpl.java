package com.levi9.drplant.documentservice.services;

import com.levi9.drplant.documentservice.api.SaveImageRequest;
import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import com.levi9.drplant.documentservice.db.repository.ImageMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageMetadataServiceImpl implements ImageMetadataService {
    private static final String BUCKET_NAME = "dr-plant-image-analysis";

    @Autowired
    ImageMetadataRepository imageMetadataRepository;
    public ImageMetadata saveImageMetadata(SaveImageRequest saveImageRequest) {
        return imageMetadataRepository.save(createImageMetadata(saveImageRequest));
    }

    private ImageMetadata createImageMetadata(SaveImageRequest saveImageRequest) {
        UUID uuid = UUID.randomUUID();
        return ImageMetadata.builder()
                            .contentType(saveImageRequest.getExtension())
                            .plant(saveImageRequest.getPlant())
                            .bucketName(BUCKET_NAME)
                            .documentId(uuid.toString())
                            .fileName(uuid + saveImageRequest.getExtension())
                            .build();
    }

}
