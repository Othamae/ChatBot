package dev.othamae.chatbot.contacts;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
@Data
public class Conversations {
    
    List<Conversation> conversations;

    public void registerConversation(Conversation conv) {
        this.conversations.add(conv);
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}


