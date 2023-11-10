package dev.othamae.chatbot.contacts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Conversation {
    
    public String chatId;

    public String username;

    public String conversationState;
   
}
