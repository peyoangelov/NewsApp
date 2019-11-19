package com.scalefocus.newsmp.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ARTICLES")
public class Article {
    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    @Column(name = "IS_ACTIVE", columnDefinition = "DEFAULT 1 NOT NULL")
    private Boolean isActive;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE_CREATED")
    private Timestamp createdOn;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "TEXT")
    @Lob
    private Clob text;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ARTICLES_HASHTAGS",
            joinColumns = {@JoinColumn(name = "ARTICLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "HASHTAG_ID")}
    )
    private List<Hashtags> hashtags = new ArrayList<Hashtags>();


}
