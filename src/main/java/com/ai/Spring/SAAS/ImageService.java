package com.ai.Spring.SAAS;

import java.io.IOError;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;




@Service
public class ImageService {
    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel){
        this.openAiImageModel =openAiImageModel;
    }

    public ImageResponse generateImage(String prompt){
        ImageResponse imageResponse =openAiImageModel.call(
            new ImagePrompt(prompt)
        );

        return imageResponse;
    }

    public ImageResponse generateImageOptions(String prompt,String quality, int n,int width,int height) {
        ImageResponse response = openAiImageModel.call(
        new ImagePrompt(prompt,
        OpenAiImageOptions.builder()
                .quality("hd")
                .N(4)
                .height(1024)
                .width(1024).build())

);
    return response;
    }
}
