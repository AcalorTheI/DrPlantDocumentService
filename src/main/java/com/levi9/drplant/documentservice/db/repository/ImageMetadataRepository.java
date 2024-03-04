package com.levi9.drplant.documentservice.db.repository;

import com.levi9.drplant.documentservice.db.entity.ImageMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMetadataRepository extends JpaRepository<ImageMetadata, Long> {
    ImageMetadata getByFileName(String fileName);
}
