package com.example.wordcounter.service;

import java.util.Map;

/**
 * Interface for working with the url-statistics repository.
 */
public interface UrlStatService {

    /**
     * Saves the result of the study - the number of occurrences of unique words in the content.
     *
     * @param urlStr - url-path of html-page
     * @param map    - the number of occurrences of unique words in the content
     */
    void save(String urlStr, Map<String, Integer> map);

}
