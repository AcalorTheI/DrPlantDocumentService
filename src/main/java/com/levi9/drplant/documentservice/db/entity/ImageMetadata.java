package com.levi9.drplant.documentservice.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "image_metadata")
public class ImageMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "creation_time")
    @CurrentTimestamp
    private String creationTime;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "plant")
    private String plant;

    @Column(name = "document_id")
    private String documentId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "bucket_name")
    private String bucketName;

    public void setTimeStamp(String timestamp) {}
}
