package com.example.wordcounter.repository;

import com.example.wordcounter.model.UrlStat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Statistics repository.
 */
public interface UrlStatRepository extends JpaRepository<UrlStat, Long> {
}
