package com.scalefocus.newsmp.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "HASHTAGS")
public class Hashtags {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "HASHTAG_NAME")
    private String name;

    @ManyToMany(mappedBy = "hashtags")
    private List<Article> article = new ArrayList<Article>();

}
