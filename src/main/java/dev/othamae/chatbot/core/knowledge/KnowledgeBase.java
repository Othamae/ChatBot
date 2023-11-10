package dev.othamae.chatbot.core.knowledge;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.othamae.chatbot.core.nlp.TextAnalyzer;
import dev.othamae.chatbot.helper.TextUtils;

@Service
public class KnowledgeBase {
    
    public final static String HELLO_MESSAGE = "Hi human! How are you?";
    public final static String DEFAULT_ANSWER = "Sorry, I did not understand. Could you please rephrase?";
    public static final String DEFAULT_IDK = "At this time, I don not possess the neccesary knowledge about it.";

    @Autowired
    SolrAPI solrAPI;

    @Autowired
    TextAnalyzer textAnalyzer;

    @Autowired
    Wikipedia wikipedia;

    @Autowired
    TextUtils textUtils;

    public String getDataFromSolr(String inputString) throws SolrServerException, IOException{
        return solrAPI.solrSearch(inputString);
    }

   public String searchForMoreKnowledge(String inputStr) throws Exception {
        String keyWord = textUtils.extractWordsAfterAbout(inputStr);
        String answer = textAnalyzer.extractRelevantSentences(
                wikipedia.wikipediaGetContent(keyWord),
                keyWord, 1
        ).get(0);

        solrAPI.solrIndexer(answer, keyWord);

        return answer;

    }
}
