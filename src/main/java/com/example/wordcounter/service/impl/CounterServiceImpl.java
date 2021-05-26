package com.example.wordcounter.service.impl;

import com.example.wordcounter.service.CounterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Implementation the counter interface.
 */
@Service
public class CounterServiceImpl implements CounterService {
    @Override
    public Map<String, Integer> countWords(String text) {
        // {' ', ',', '.', '!', '?','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};
        final String regex = "\\s+[-–—]\\s+|[,!?\";:\\[\\]()\n\r\t/]\\s*|\\s+|\\. ";
        String[] words = text.split(regex);

        Pattern toRemove = Pattern.compile("^[\\d-]+%?$|\\d{2}\\.\\d{2}\\.\\d{4}");

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (s.isEmpty() || toRemove.matcher(s).matches()) {
                continue;
            }
            String key = s.replaceAll("^'|'$|[«»]", "").toUpperCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map;
    }
}
