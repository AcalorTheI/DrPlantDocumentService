package com.levi9.drplant.documentservice.api;

import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import com.levi9.drplant.documentservice.db.repository.ImageMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorld {
    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok().body("Hello world");
    }

    @GetMapping("/hello-rds")
    public ResponseEntity<List<ImageMetadata>> helloRDS() {
        return ResponseEntity.ok(imageMetadataRepository.findAll());
    }
}
