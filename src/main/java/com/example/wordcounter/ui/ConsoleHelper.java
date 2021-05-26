package com.example.wordcounter.ui;

import java.util.Map;

/**
 * User interface.
 */
public interface ConsoleHelper {
    /**
     * The method outputs messages.
     *
     * @param msg сообщение
     */
    void print(String msg);

    /**
     * The method reads user input.
     *
     * @return input string
     */
    String read(String msg);

    /**
     * The method outputs the map.
     *
     * @param map of pairs string and number
     */
    void printMap(Map<String, Integer> map);
}
