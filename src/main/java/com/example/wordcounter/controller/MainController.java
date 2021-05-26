package com.example.wordcounter.controller;

import com.example.wordcounter.service.CounterService;
import com.example.wordcounter.service.DownloadService;
import com.example.wordcounter.service.ParsingService;
import com.example.wordcounter.service.UrlStatService;
import com.example.wordcounter.ui.ConsoleHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * The main application controller.
 * Provides the execution order of the application.
 */
@Component
@Slf4j
public class MainController implements CommandLineRunner {
    private final ConsoleHelper consoleHelper;
    private final DownloadService downloadService;
    private final ParsingService parsingService;
    private final CounterService counterService;
    private final UrlStatService urlStatService;

    @Autowired
    public MainController(ConsoleHelper consoleHelper,
                          DownloadService downloadService,
                          ParsingService parsingService,
                          CounterService counterService,
                          UrlStatService urlStatService) {
        this.consoleHelper = consoleHelper;
        this.downloadService = downloadService;
        this.parsingService = parsingService;
        this.counterService = counterService;
        this.urlStatService = urlStatService;
    }

    /**
     * The method performs the main logic of the program
     * @param args input arguments are optional,
     * 	           the first argument is expected to be the url of the html page to download,
     * 	           the second argument is expected to be the file name for saving the downloaded html page.
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        String urlStr;
        if (args.length > 0) {
            urlStr = args[0];
        } else {
            urlStr = consoleHelper.read("Input the URL: ");
        }
        if (urlStr.isEmpty()) {
            String errorMsg = "Url is empty!";
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

        String filename;
        boolean toDeleteFile = false;
        if (args.length > 1) {
            filename = args[1];
        } else {
            toDeleteFile = true;
            try {
                filename = File.createTempFile("downloaded", "tmp").getPath();
            } catch (IOException e) {
                String errorMsg = "Couldn't create a temporary file to save the html-page";
                log.error(e.getMessage());
                throw new IllegalArgumentException(errorMsg, e);
            }
        }

        downloadService.downloadUrl(urlStr, filename);
        Map<String, Integer> map = counterService.countWords(parsingService.parse(filename));

        try {
            urlStatService.save(urlStr, map);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        consoleHelper.print(String.format("Statistics of %s", urlStr));
        consoleHelper.printMap(map);

        if (toDeleteFile) {
            Path path = Path.of(filename);
            if (Files.exists(path)) {
                try {
                    Files.delete(path);
                } catch (IOException ignored) {
                }
            }
        }
    }
}
