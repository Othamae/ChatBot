package dev.othamae.chatbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {

    @Value("${SOLR_BASE_URL}")
    public static String SOLR_BASE_URL;

    @Value("${SOLR_CORE}")
    public static String SOLR_CORE;
    
    @Value("${SOLR_CONTENT_FIELD}")
    public static String SOLR_CONTENT_FIELD;
    
    @Value("${SOLR_CONTENT_KEY}")
    public static String SOLR_CONTENT_KEY;

}