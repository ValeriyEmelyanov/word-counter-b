package com.example.wordcounter.service.impl;

import com.example.wordcounter.model.UrlStat;
import com.example.wordcounter.model.Word;
import com.example.wordcounter.model.WordStat;
import com.example.wordcounter.repository.UrlStatRepository;
import com.example.wordcounter.repository.WordRepository;
import com.example.wordcounter.service.UrlStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation url statistics interface.
 */
@Service
public class UrlStatServiceImpl implements UrlStatService {
    private final WordRepository wordRepository;
    private final UrlStatRepository urlStatRepository;

    @Autowired
    public UrlStatServiceImpl(WordRepository wordRepository,
                              UrlStatRepository urlStatRepository) {
        this.wordRepository = wordRepository;
        this.urlStatRepository = urlStatRepository;
    }

    @Override
    public void save(String urlStr, Map<String, Integer> map) {
        int collectionSize = map.size();

        Map<String, Word> words = new HashMap<>(collectionSize);
        for (String wordName : map.keySet()) {
            Word byName = wordRepository.findByName(wordName);
            if (byName == null) {
                Word word = new Word();
                word.setName(wordName);
                byName = wordRepository.save(word);
            }
            words.put(wordName, byName);
        }

        UrlStat urlStat = new UrlStat();
        urlStat.setUrl(urlStr);

        List<WordStat> wordStatList = new ArrayList<>(collectionSize);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordStat wordStat = new WordStat();
            wordStat.setWord(words.get(entry.getKey()));
            wordStat.setAmount(entry.getValue());
            wordStat.setUrlStat(urlStat);
            wordStatList.add(wordStat);
        }
        urlStat.setWordCountList(wordStatList);
        urlStatRepository.save(urlStat);
    }
}
