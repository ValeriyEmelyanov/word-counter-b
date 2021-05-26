package com.example.wordcounter.service.impl;

import com.example.wordcounter.exception.ParsingException;
import com.example.wordcounter.service.ParsingService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Implementation of html page content extraction using the Jsoup library.
 */
@Service
@Slf4j
public class ParsingServiceImpl implements ParsingService {
    /**
     * The method Extracts content from an html file.
     *
     * @param filename the file name
     * @return the content
     */
    @Override
    public String parse(String filename) {
        try {
            Document doc = Jsoup.parse(new File(filename), null);
            return doc.text();
        } catch (IOException e) {
            String errorMsg = "Parsing failed";
            log.error(e.getMessage());
            throw new ParsingException(errorMsg, e);
        }
    }
}
