package com.levi9.drplant.documentservice.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class BucketConfig {

    @Value("${bucket-endpoint}")
    private String bucketEndpoint;
    @Value("${access-key}")
    private String accessKey;
    @Value("${secret-key}")
    private String secretKey;

    @Bean
    @Profile("aws")
    public S3Client getAmazonS3Client() {
        return S3Client.builder().region(Region.EU_WEST_1).build();
    }

    @Bean
    @Profile("local")
    public S3Client getMinIOClient() {
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
        return S3Client.builder()
                       .endpointOverride(URI.create(bucketEndpoint))
                       .region(Region.EU_WEST_1)
                       .credentialsProvider(StaticCredentialsProvider.create(credentials))
                       .build();
    }
}
