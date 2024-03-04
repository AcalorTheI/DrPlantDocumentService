package com.levi9.drplant.documentservice;

import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import com.levi9.drplant.documentservice.db.repository.ImageMetadataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ImageMetadataDBTest {
    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    @Test
    void injectedComponentsAreNotNull(){
        UUID uuid = UUID.randomUUID();
        ImageMetadata imageMetadata = ImageMetadata.builder()
                .contentType(".jpg")
                .plant("TULIP")
                .bucketName("dr-plant-images-analysis")
                .documentId(uuid.toString())
                .fileName(uuid + ".jpg")
                .build();
        imageMetadataRepository.save(imageMetadata);
        ImageMetadata save = imageMetadataRepository.getByFileName(imageMetadata.getFileName());

        assertThat(save).isNotNull();
        assertThat(save.getDocumentId()).isEqualTo(uuid.toString());
        assertThat(save.getPlant()).isEqualTo("TULIP");
        assertThat(save.getCreationTime()).isNotNull();
    }
}
