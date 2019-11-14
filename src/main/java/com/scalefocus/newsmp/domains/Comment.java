package com.scalefocus.newsmp.domains;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQUENCE")
    @SequenceGenerator(sequenceName = "COMMENTS_SEQUENCE", name = "COMMENTS_SEQUENCE", allocationSize = 1)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "USER_ID")
    private User commentator;

    @ManyToOne(targetEntity = Article.class)
    private Article article;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "DATE_CREATED")
    private Timestamp createdOn;

    @Column(name = "POSITIVE_VOTE")
    private int positiveVote;

    @Column(name = "NEGATIVE_VOTE")
    private int negativeVote;

    @Column(name = "TEXT")
    private String text;

    public Comment() {
    }

    public Comment(User commentator, Article article, boolean isActive, Timestamp createdOn, int positiveVote, int negativeVote, String text) {
        this.commentator = commentator;
        this.article = article;
        this.isActive = isActive;
        this.createdOn = createdOn;
        this.positiveVote = positiveVote;
        this.negativeVote = negativeVote;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public int getPositiveVote() {
        return positiveVote;
    }

    public void setPositiveVote(int positiveVote) {
        this.positiveVote = positiveVote;
    }

    public int getNegativeVote() {
        return negativeVote;
    }

    public void setNegativeVote(int negativeVote) {
        this.negativeVote = negativeVote;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
