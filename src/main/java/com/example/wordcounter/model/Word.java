package com.example.wordcounter.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Word enity.
 */
@Data
@Entity
@Table(name = "word")
public class Word {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Word
     */
    @Column(name = "name")
    private String name;
}
