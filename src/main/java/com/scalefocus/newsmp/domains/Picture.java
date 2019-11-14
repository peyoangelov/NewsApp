package com.scalefocus.newsmp.domains;


import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "PICTURES")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PICTURES_SEQUENCE")
    @SequenceGenerator(sequenceName = "PICTURES_SEQUENCE", name = "PICTURES_SEQUENCE", allocationSize = 1)
    @Column(name = "PICTURE_ID")
    private Long id;

    @ManyToOne(targetEntity = Article.class)
    private Article article;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "DATE_CREATED")
    private Timestamp dateCreated;

    @Column(name = "ITEM")
    private Blob item;

    public Picture() {
    }

    public Picture(Article article, Boolean isActive, String fileName, Timestamp dateCreated, Blob item) {
        this.article = article;
        this.isActive = isActive;
        this.fileName = fileName;
        this.dateCreated = dateCreated;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Blob getItem() {
        return item;
    }

    public void setItem(Blob item) {
        this.item = item;
    }
}
