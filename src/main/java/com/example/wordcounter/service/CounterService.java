package com.example.wordcounter.service;

import java.util.Map;

/**
 * Interface for counting words.
 */
public interface CounterService {

    /**
     * The method counts the number of unique words in the text (string).
     *
     * @param text the text (string) in which the words should be counted
     * @return a map containing unique words in the form of keys, and their number of occurrences in the text as values
     */
    Map<String, Integer> countWords(String text);

}
