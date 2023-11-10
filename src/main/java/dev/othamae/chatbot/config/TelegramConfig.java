package dev.othamae.chatbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramConfig {
    
    @Value("${BASE_URL}")
    public static String BASE_URL;  

    @Value("${BOT_PREFIX}")
    public static String BOT_PREFIX;

    @Value("${TOKEN}")
    public static String TOKEN;   

    @Value("${CHAT_ID}")
    public static String CHAT_ID;   
    
    public static String MESSAGE_SENT = "SENT\t";
    public static String MESSAGE_RECEIVED = "RECEIVED\t";



}
