package com.example.wordcounter.service;

import org.springframework.stereotype.Service;

/**
 * Interface for downloading a file from the Internet.
 */
@Service
public interface DownloadService {

    /**
     * The method Downloads a file.
     *
     * @param urlStr   URL of file
     * @param filename name of the file to save to disk
     */
    void downloadUrl(String urlStr, String filename);

}
