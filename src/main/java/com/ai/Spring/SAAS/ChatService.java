package com.ai.Spring.SAAS;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;



@Service
public class ChatService {
    private  final ChatModel chatModel; //instance 

    public ChatService(ChatModel chatModel){ //constructor
        this.chatModel =chatModel;
    }

    //method - calling prompt
    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }

    //method - calling prompt
    public String getResponseOptions(String prompt){
    try {
        ChatResponse response = chatModel.call(
            new Prompt(
                prompt,
                OpenAiChatOptions.builder()
                    .model("gpt-4-o")
                    .temperature(0.4)
                .build()
            ));
        
        return response.getResult().getOutput().getContent();
            
    } catch (Exception e) {
        return null;
    }
}

}
