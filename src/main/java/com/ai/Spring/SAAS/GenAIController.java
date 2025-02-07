package com.ai.Spring.SAAS;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    RecipeService recipeService;

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
    public void generateImage(HttpServletResponse response, @RequestParam  String prompt) throws IOException{
        ImageResponse imageResponse = imageService.generateImage(prompt);

        String imageUrl =imageResponse.getResult().getOutput().getUrl();
        //now ,redirect user to this imageUrl
         response.sendRedirect(imageUrl);
    }


    @GetMapping("/generate-image-options")
    public List<?> generateImageOptions(
        HttpServletResponse response,
     @RequestParam  String prompt,
     @RequestParam( defaultValue = "hd") String quality,
     @RequestParam( defaultValue = "1") int n,
     @RequestParam( defaultValue = "1024") int width,
     @RequestParam( defaultValue = "1024") int height
    ) throws IOException{
        ImageResponse imageResponse = imageService.generateImageOptions(prompt,quality,n,width,height);

        // String imageUrl =imageResponse.getResult().getOutput().getUrl();
        // //now ,redirect user to this imageUrl
        //  response.sendRedirect(imageUrl);

        //get url -Streams to get urls from ImageResposne
        List<String> imageUrls =imageResponse.getResults().stream()
            .map(result -> result.getOutput().getUrl())
            .collect(Collectors.toList()); // collect all url as list

            return imageUrls;
    }

    @GetMapping("recipe-create")
    public String  recipeCreator(
        @RequestParam String ingredients,
        @RequestParam(defaultValue = "any") String cuisine ,
        @RequestParam(defaultValue = "Oil") String dietaryRestrictions
    ){

return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);

    }
}
