package com.levi9.drplant.documentservice.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveImageRequest {
    private String plant;
    private String extension;
    private String base64Image;
}
