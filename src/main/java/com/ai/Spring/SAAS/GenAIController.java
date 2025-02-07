package com.ai.Spring.SAAS;

import java.io.IOException;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GenAIController {

    @Autowired
    ChatService chatService;

    @Autowired
    ImageService imageService;

    public GenAIController(ChatService chatService,ImageService imageService){
        this.chatService =chatService;
        this.imageService =imageService;
    }

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt){ //it method route call
        return chatService.getResponse(prompt);
    }

    @GetMapping("/ask-ai-options")
    public String getResponseOptions(@RequestParam  String prompt){
        return chatService.getResponseOptions(prompt);
    }

    @GetMapping("/generate-image")
    public void generateImages(HttpServletResponse response, @RequestParam  String prompt) throws IOException{
        ImageResponse imageResponse = imageService.generateImage(prompt);

        String imageUrl =imageResponse.getResult().getOutput().getUrl();
        //now ,redirect user to this imageUrl
         response.sendRedirect(imageUrl);
    }
}
