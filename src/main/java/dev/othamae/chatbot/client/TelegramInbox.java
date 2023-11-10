package dev.othamae.chatbot.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import dev.othamae.chatbot.core.Agent;
import jakarta.annotation.PostConstruct;

@Service
public class TelegramInbox {
    
       @Value("${TOKEN}")
    public String TOKEN; 
    TelegramBot bot;
    @PostConstruct public void init() { bot = new TelegramBot(TOKEN); }

    @Autowired
    Agent agent;

    // check the message inbox
    @PostConstruct
    public void getUnreadMessages(){
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list){
                for (Update update : list){
                    try {
                        agent.generateReply(update.message());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }                
                return -1;
            }
        });
    }
}
