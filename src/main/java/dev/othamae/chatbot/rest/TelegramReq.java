package dev.othamae.chatbot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.othamae.chatbot.client.TelegramDelivery;
import dev.othamae.chatbot.contacts.Conversation;


@RestController
public class TelegramReq {

    @Autowired
    TelegramDelivery telegramDelivery;

      @Value("${CHAT_ID}")
    public String CHAT_ID;   

    @GetMapping("/hi/{inputMessage}")
    public String hi(@PathVariable("inputMessage") String inputMessage) throws Exception{
        System.out.println("Input message: " + inputMessage);
        telegramDelivery.sendMessage(new Conversation(CHAT_ID , "", "manual"), inputMessage);
        return "Hi!";
    }
    
}
