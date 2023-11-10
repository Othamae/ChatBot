package dev.othamae.chatbot.core.lifecycle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Flow {

    public List<State> setupFlow(){

        List<State> flow = new ArrayList<>();

        flow.add(new State("Greetings", 0, new String[]{"hi", "hello", "ping", "Hi!", "Hello!"}, null, null));
        flow.add(new State("Question", 1, new String[]{"?", "why?", "where?", "when?", "what?"}, null, null));
        flow.add(new State("Exclamation", 2, new String[]{"!"}, null, null));
        flow.add(new State("Followup", 3, new String[]{"more", "additional", "details"}, null, null));
        flow.add(new State("Closing", 4, new String[]{"bye", "exit", "stop", "quit"}, null, null));
        
   
        return flow;
    }

    public State getDefaultState() {
        return new State("DefaultState", 9999, null, null, null);
    }
    
}
