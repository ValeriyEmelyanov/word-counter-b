package com.example.wordcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the program.
 */
@SpringBootApplication
public class WordCounterBApplication {

    /**
     * The method is used to launch the application.
     *
     * @param args input arguments are optional,
     *             the first argument is expected to be the url of the html page to download,
     *             the second argument is expected to be the file name for saving the downloaded html page.
     */
    public static void main(String[] args) {
        SpringApplication.run(WordCounterBApplication.class, args);
    }

}
