package com.example.wordcounter.service;

/**
 * Interface responsible for extracting content from an html file.
 */
public interface ParsingService {

    /**
     * Method extracts content from an html file.
     *
     * @param filename the file name
     * @return the content
     */
    String parse(String filename);

}
