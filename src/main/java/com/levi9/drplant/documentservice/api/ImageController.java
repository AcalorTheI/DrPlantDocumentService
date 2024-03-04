package com.levi9.drplant.documentservice.api;

import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import com.levi9.drplant.documentservice.services.AWSS3BucketService;
import com.levi9.drplant.documentservice.services.ImageMetadataService;
import com.levi9.drplant.documentservice.util.Image;
import com.levi9.drplant.documentservice.util.Util;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@RestController
public class ImageController {
    @Autowired
    AWSS3BucketService awss3BucketService;
    @Autowired
    ImageMetadataService imageMetadataService;

    @GetMapping("/all-images")
    public ResponseEntity<List<ImageResponse>> getAllImages() {
        List<Image> images = awss3BucketService.readAllImagesFromS3();
        return ResponseEntity.ok(Util.getImageResponseFromImages(images));
    }

    @PostMapping("/save-image")
    public ResponseEntity<String> saveImageToBucket(@NotNull @RequestBody SaveImageRequest saveImageRequest) {
        byte[] base64Image = Util.decodeImage(saveImageRequest.getBase64Image());
        ImageMetadata imageMetadata = imageMetadataService.saveImageMetadata(saveImageRequest);
        awss3BucketService.saveToS3(base64Image, imageMetadata.getFileName());
        return ResponseEntity.ok().body(imageMetadata.getFileName());
    }


}
