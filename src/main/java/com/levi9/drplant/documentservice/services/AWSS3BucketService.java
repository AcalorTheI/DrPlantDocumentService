package com.levi9.drplant.documentservice.services;

import com.levi9.drplant.documentservice.util.Image;

import java.util.List;

public interface AWSS3BucketService {
     void saveToS3(byte[] image, String name);

     List<Image> readAllImagesFromS3();
     byte[] readFromS3(String userId) throws Exception;
}
