package com.example.wordcounter.ui.impl;

import com.example.wordcounter.ui.ConsoleHelper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

/**
 * Implementation of the user interface via the sysstem console.
 */
@Component
public class ConsoleHelperImpl implements ConsoleHelper {
    private final Scanner scanner;

    public ConsoleHelperImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String read(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    @Override
    public void printMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> System.out.printf("%s - %d\n", x.getKey(), x.getValue()));
    }
}
