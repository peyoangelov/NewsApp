package com.scalefocus.newsmp.domains;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQUENCE")
    @SequenceGenerator(name = "ROLES_SEQUENCE", sequenceName = "ROLES_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "AUTHORITY")
    private String authority;

    @Column(name = "DESCRIPTION")
    private String description;

    public Role() {
    }

    public Role(String authority, String description) {
        this.authority = authority;
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
