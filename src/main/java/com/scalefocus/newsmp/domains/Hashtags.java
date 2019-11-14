package com.scalefocus.newsmp.domains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HASHTAGS")
public class Hashtags {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HASHTAGS_SEQUENCE")
    @SequenceGenerator(sequenceName = "HASHTAGS_SEQUENCE", name = "HASHTAGS_SEQUENCE", allocationSize = 1)
    @Column(name = "HASHTAG_ID")
    private Long id;

    @Column(name = "HASHTAG_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ARTICLES_HASHTAGS",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "HASHTAG_ID"))
    private List<Article> article;


    public Hashtags() {
    }

    public Hashtags(String name, List<Article> article) {
        this.name = name;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
