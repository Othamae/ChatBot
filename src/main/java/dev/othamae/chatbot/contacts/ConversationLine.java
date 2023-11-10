package dev.othamae.chatbot.contacts;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name= "conversation_lines")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ConversationLine implements Serializable{

    @Id
    @Column(name = "lineId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;    

    @Column(name= "chatId")
    private String chat_id;

    @Column(name= "username")
    private String username;

    @Column(name= "conversationState")
    private String conversationState;

    @Column(name= "message")
    private String message;

    @Column(name= "messageType")
    private String messageType;

    public ConversationLine(String chat_id, String username, String conversationState, String message,
                            String messageType) {
        this.chat_id = chat_id;
        this.username = username;
        this.conversationState = conversationState;
        this.message = message;
        this.messageType = messageType;
    }
}
