package com.levi9.drplant.documentservice.services;

import com.levi9.drplant.documentservice.api.SaveImageRequest;
import com.levi9.drplant.documentservice.db.entity.ImageMetadata;

public interface ImageMetadataService {
    ImageMetadata saveImageMetadata(SaveImageRequest saveImageRequest);
}
