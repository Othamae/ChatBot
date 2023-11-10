package dev.othamae.chatbot.core.nlp;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@Service
public class SentimentAnalyzer {

    public String sentimentAnalyzer(String text) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String retSentiment = "";

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences = coreDocument.sentences();

        for (CoreSentence sentence : sentences) {
            String sentiment = sentence.sentiment();
            retSentiment = retSentiment + " " + sentiment;
        }
        return retSentiment;
    }
}
