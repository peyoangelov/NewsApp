package com.scalefocus.newsmp.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;
    @Column(name = "USER_ID")
    private User commentator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
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


}
