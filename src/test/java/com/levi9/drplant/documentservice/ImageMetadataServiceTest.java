package com.levi9.drplant.documentservice;

import com.levi9.drplant.documentservice.api.ImageResponse;
import com.levi9.drplant.documentservice.api.SaveImageRequest;
import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import com.levi9.drplant.documentservice.db.repository.ImageMetadataRepository;
import com.levi9.drplant.documentservice.services.AWSS3BucketService;
import com.levi9.drplant.documentservice.util.Image;
import com.levi9.drplant.documentservice.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ImageMetadataServiceTest {
    private static String DOCUMENT_SERVICE_URL = "http://localhost:8091";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ImageMetadataRepository imageMetadataRepository;

    @MockBean
    private AWSS3BucketService awss3BucketService;

    @ParameterizedTest
    @MethodSource("com.levi9.drplant.documentservice.config.ImageSource#getImageAndMetadata")
    public void testSaveOfTheImage(String input) {
        String plant = input.split(",")[2];
        String extension = input.split(",")[1];
        String base64Image = input.split(",")[0];
        Mockito.doNothing().when(awss3BucketService).saveToS3(ArgumentMatchers.eq(Util.decodeImage(base64Image)), any());

        SaveImageRequest saveRequest = new SaveImageRequest(plant, extension, base64Image);
        RequestEntity<SaveImageRequest> saveImageRequest = RequestEntity.post(DOCUMENT_SERVICE_URL + "/save-image").body(saveRequest);

        ResponseEntity<String> exchange = restTemplate.exchange(saveImageRequest, String.class);
        Assertions.assertTrue(exchange.getStatusCode().is2xxSuccessful());

        List<ImageMetadata> listOfMetadata = imageMetadataRepository.findAll();
        Assertions.assertFalse(listOfMetadata.isEmpty());

    }

    @ParameterizedTest
    @MethodSource("com.levi9.drplant.documentservice.config.ImageSource#getImageAndMetadata")
    public void testGetAllImages(String input) {
        String name = UUID.randomUUID().toString() + ".jpg";
        String base64Image = input.split(",")[0];
        Mockito.when(awss3BucketService.readAllImagesFromS3())
                .thenReturn(List.of(new Image(name, Util.decodeImage(base64Image))));

        RequestEntity<Void> request = RequestEntity.get(DOCUMENT_SERVICE_URL + "/all-images").build();

        ResponseEntity<ImageResponse[]> exchange = restTemplate.exchange(request, ImageResponse[].class);
        Assertions.assertTrue(exchange.getStatusCode().is2xxSuccessful());
        long count = Arrays.stream(exchange.getBody()).filter(x -> x.getName().equals(name)).count();
        assertEquals(1, count);
    }

}
