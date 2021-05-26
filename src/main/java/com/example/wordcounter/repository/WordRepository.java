package com.example.wordcounter.repository;

import com.example.wordcounter.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Word repository.
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    Word findByName(String name);
}
