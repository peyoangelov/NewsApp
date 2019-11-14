package com.scalefocus.newsmp.domains;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ARTICLES")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLES_SEQUENCE")
    @SequenceGenerator(sequenceName = "ARTICLES_SEQUENCE", name = "ARTICLES_SEQUENCE", allocationSize = 1)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User creator;

    @ManyToOne(targetEntity = Category.class)
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
    private Clob text;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ARTICLES_HASHTAGS",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "HASHTAG_ID"))
    private List<Hashtags> hashtags;


    public Article() {
    }

    public Article(User creator, Category category, Boolean isActive, String title, Timestamp createdOn, int rating, Clob text, List<Hashtags> hashtags) {
        this.creator = creator;
        this.category = category;
        this.isActive = isActive;
        this.title = title;
        this.createdOn = createdOn;
        this.rating = rating;
        this.text = text;
        this.hashtags = hashtags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Clob getText() {
        return text;
    }

    public void setText(Clob text) {
        this.text = text;
    }

    public List<Hashtags> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtags> hashtags) {
        this.hashtags = hashtags;
    }
}
