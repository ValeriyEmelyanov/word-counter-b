package com.example.wordcounter.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * An entity containing реьд page statistics:
 * - the number of occurrences of unique words in the content.
 */
@Data
@Entity
@Table(name = "url_stat")
public class UrlStat {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * URL
     */
    @Column(name = "url")
    private String url;

    /**
     * Date and time of the html page research
     */
    @Column(name = "viewed")
    @UpdateTimestamp
    private LocalDateTime viewed;

    /**
     * Statistics: the number of occurrences of unique words in the content
     */
    @OneToMany(mappedBy = "urlStat", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WordStat> wordCountList;
}
