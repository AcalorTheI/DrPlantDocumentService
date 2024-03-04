package com.levi9.drplant.documentservice.services;

import com.levi9.drplant.documentservice.util.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class AWSS3BucketServiceImpl implements AWSS3BucketService {
    @Value("${bucket-name}")
    private String bucketName;

    @Autowired
    private S3Client client;

    public void saveToS3(byte[] image, String name) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(name).build();
        RequestBody requestBody = RequestBody.fromBytes(image);
        client.putObject(putObjectRequest, requestBody);
    }

    public List<Image> readAllImagesFromS3() {
        ListObjectsRequest listObjectsRequest = ListObjectsRequest.builder().bucket(bucketName).build();
        ListObjectsResponse listObjectsResponse = client.listObjects(listObjectsRequest);
        List<S3Object> contents = listObjectsResponse.contents();
        List<Image> listOfImages = new ArrayList<>();

        for (S3Object object: contents) {
            String key = object.key();
            byte[] objectFromBucket = getObjectFromBucket(key);
            listOfImages.add(new Image(key, objectFromBucket));
        }

        return listOfImages;
    }

    @Override
    public byte[] readFromS3(String user) throws Exception {
        throw new Exception("Operation not implemented!");
    }

    private byte[] getObjectFromBucket(String key) {
        GetObjectRequest objectRequest  = GetObjectRequest.builder().bucket(bucketName).key(key).build();
        ResponseInputStream<GetObjectResponse> object = client.getObject(objectRequest);
        try {
            return object.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
