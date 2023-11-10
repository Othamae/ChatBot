package dev.othamae.chatbot.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import dev.othamae.chatbot.config.TelegramConfig;
import dev.othamae.chatbot.contacts.Conversation;
import dev.othamae.chatbot.helper.MessageParser;
import jakarta.annotation.PostConstruct;

@Service
public class TelegramDelivery {
    
    @Autowired
    MessageParser messageParser;

    // @Autowired
    // RDS rds;
    
    @Value("${TOKEN}")
    public String TOKEN; 

    TelegramBot bot;
    @PostConstruct public void init() { bot = new TelegramBot(TOKEN); }
   // TelegramBot bot = new TelegramBot(TOKEN);
   // List<Update> unreadMessages = new ArrayList<>();

    // send messages
    public void sendMessage(Conversation conversation, String rawMessage) {
        SendMessage sendRequest = new SendMessage(conversation.getChatId(), rawMessage);
        SendResponse sendResponse = bot.execute(sendRequest);

        if (sendResponse.isOk()){
            messageParser.printMessage(TelegramConfig.MESSAGE_SENT, sendResponse.message());
        } else{
                 System.out.println("The message could not be sent");
        }

    }

}
