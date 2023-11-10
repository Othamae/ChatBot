package dev.othamae.chatbot.contacts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Person {
    
    private String username;
    private String firstname;
    private String lastname;
}
