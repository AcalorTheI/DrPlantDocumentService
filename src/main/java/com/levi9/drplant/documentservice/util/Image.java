package com.levi9.drplant.documentservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String keyName;
    private byte[] image;
}
