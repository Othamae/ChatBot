package dev.othamae.chatbot.core.lifecycle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.othamae.chatbot.core.nlp.SentimentAnalyzer;
import dev.othamae.chatbot.helper.TextUtils;

@Service
public class DecisionEngine {
    
    @Autowired
    Flow flow;

    @Autowired
    TextUtils textUtils;

     @Autowired
    SentimentAnalyzer sentimentAnalyzer;

    public State decideCurrentConversationState(String text) {
        List<State> candidateStates = new ArrayList<>();
        for (State state : flow.setupFlow()) {
            if (textUtils.containAnyWord(text, state.getKeywords())) {
                candidateStates.add(state);
            }
        }
        if (!candidateStates.isEmpty()) {
            return candidateStates.stream().
                    min(Comparator.comparing(State::getPriority)).orElse(null);
        }
        return flow.getDefaultState();
    }

    public String sentimentAnalyzerMessage(String inputText) {
        return "By the way, you mood is now: "
                + sentimentAnalyzer.sentimentAnalyzer(inputText);
    }
}
