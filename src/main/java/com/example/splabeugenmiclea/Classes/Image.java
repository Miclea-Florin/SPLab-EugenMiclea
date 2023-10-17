package com.example.splabeugenmiclea.Classes;

import lombok.Data;
@Data
public class Image {
    String ImageName;

    @Override
    public String toString() {
        return "Image{" +
                "ImageName='" + ImageName + '\'' +
                '}';
    }

    public Image(String imageName) {
        ImageName = imageName;
    }
}
