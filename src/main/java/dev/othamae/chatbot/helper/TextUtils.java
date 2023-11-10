package dev.othamae.chatbot.helper;

import org.springframework.stereotype.Service;

@Service
public class TextUtils {
    
  
    public boolean containAnyWord(String text, String[] words) {
        String[] tokens = text.split("\\s+");
        for (String token : tokens) {
            for (String word : words) {
                if (token.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        
        }
        return false;
    }

    public String extractWordsAfterAbout(String text) {
        return text;
    }
    
}
