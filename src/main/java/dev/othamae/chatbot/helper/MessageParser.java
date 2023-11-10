package dev.othamae.chatbot.helper;

import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.model.Message;

@Service
public class MessageParser {
    
    public void printMessage (String messageType, Message message){
        String hrMessage = messageType + message.chat().id() + ", " 
        + message.chat().username() + " -> " + message.text();

        System.out.println(hrMessage);
    }
}
