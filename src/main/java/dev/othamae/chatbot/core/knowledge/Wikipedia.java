package dev.othamae.chatbot.core.knowledge;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Wikipedia {

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";

    @Autowired
    SolrAPI solrAPI;

    public String wikipediaGetContent(String keyword) throws Exception{

        String wikiPageUrl = WIKIPEDIA_URL + keyword.replace(" ","_");
        String wikiPageContent = "";

        try {
            // Fetch the Wikipedia page for the search query
            Document doc = Jsoup.connect(wikiPageUrl).get();

            // extract the content of the page
            Element content = doc.select("div#mw-content-text").first();
            if (content !=null )
            wikiPageContent = content.text();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wikiPageContent;
    }
    
}
