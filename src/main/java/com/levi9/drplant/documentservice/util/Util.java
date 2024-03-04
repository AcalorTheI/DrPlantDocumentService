package com.levi9.drplant.documentservice.util;

import com.levi9.drplant.documentservice.api.ImageResponse;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Util {

    public static List<ImageResponse> getImageResponseFromImages(List<Image> images) {
        List<ImageResponse> listOfResponses = new ArrayList<>();

        for (Image image: images) {
            listOfResponses.add(new ImageResponse(image.getKeyName(), encodeImage(image.getImage())));
        }

        return listOfResponses;
    }
    public static byte[] decodeImage(String input) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(input);
    }

    public static String encodeImage(byte[] image) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(image);
    }
}
