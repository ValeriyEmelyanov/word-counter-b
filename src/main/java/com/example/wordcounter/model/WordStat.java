package com.example.wordcounter.model;

import lombok.Data;

import javax.persistence.*;

/**
 * The entity describes the number of occurrences of the word per html page
 */
@Data
@Entity
@Table(name = "word_stat")
public class WordStat {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Parent entity
     */
    @ManyToOne
    @JoinColumn(name = "url_stat_id")
    private UrlStat urlStat;

    /**
     * Word
     */
    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    /**
     * Number of occurrences of the word
     */
    @Column(name = "amount")
    private int amount;
}
