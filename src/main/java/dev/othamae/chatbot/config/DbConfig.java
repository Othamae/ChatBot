package dev.othamae.chatbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    
      @Value("${POSTGRES_URL}")
    public static String DB_URL ;  

    @Value("${POSTGRES_USERNAME}")
    public static String DB_USER ;

    @Value("${POSTGRES_PASSWORD}")
    public static String DB_PASS ;   
}
