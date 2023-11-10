package dev.othamae.chatbot.core.lifecycle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class State {
    
    private String name;

    private int priority;

    private String[] keywords;

    private String parent;

    private String child;
}
