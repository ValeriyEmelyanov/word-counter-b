package com.example.wordcounter.service.impl;

import com.example.wordcounter.exception.DownloadException;
import com.example.wordcounter.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implementation the file download interface.
 */
@Service
@Slf4j
public class DownloadServiceImpl implements DownloadService {

    @Override
    public void downloadUrl(String urlStr, String filename) {
        try {
            URL url = new URL(urlStr);
            Files.copy(url.openStream(), Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            String errorMessage = String.format("Failed to download file: %s.", urlStr);
            log.error(e.getMessage());
            throw new DownloadException(errorMessage, e);
        }
    }

}
