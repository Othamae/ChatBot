package dev.othamae.chatbot.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.model.Message;

import dev.othamae.chatbot.client.TelegramDelivery;
import dev.othamae.chatbot.config.TelegramConfig;
import dev.othamae.chatbot.contacts.Conversation;
import dev.othamae.chatbot.core.knowledge.KnowledgeBase;
import dev.othamae.chatbot.core.lifecycle.DecisionEngine;
import dev.othamae.chatbot.helper.MessageParser;
import dev.othamae.chatbot.helper.TextUtils;
import dev.othamae.chatbot.persistent.RDS;

@EnableScheduling
@Component
public class Agent {
    
    @Autowired
    DecisionEngine decisionEngine;

    @Autowired
    KnowledgeBase knowledgeBase;

    @Autowired
    MessageParser messageParser;

    @Autowired
    TelegramDelivery telegramDelivery;

    @Autowired
    TextUtils textUtils;

    @Autowired
    RDS rds;


    String answer;

    public void generateReply(Message message) throws Exception{

        String conversationState = decisionEngine.decideCurrentConversationState(message.text()).getName();

        Conversation conversation = new Conversation(String.valueOf(message.chat().id()), message.chat().username(), conversationState);

        switch (conversationState) {
            case "Greetings" ->{
                answer = KnowledgeBase.HELLO_MESSAGE;
            }
            case "Question" -> {
                answer = knowledgeBase.getDataFromSolr(
                        textUtils.extractWordsAfterAbout(message.text())
                );
                if (answer.isEmpty()) {
                    answer = KnowledgeBase.DEFAULT_IDK;
                    telegramDelivery.sendMessage(conversation, answer);
                    answer = knowledgeBase.searchForMoreKnowledge(message.text());
                }
            }
            default -> answer = KnowledgeBase.DEFAULT_ANSWER;               
        }
            // print to console
            messageParser.printMessage(TelegramConfig.MESSAGE_RECEIVED, message);

            // save to database
            rds.saveMessage(conversation, answer, TelegramConfig.MESSAGE_RECEIVED);

            // deliver the message
            telegramDelivery.sendMessage(conversation,
                    answer);
            telegramDelivery.sendMessage(conversation,
                    decisionEngine.sentimentAnalyzerMessage(message.text())
            );

    }

}
