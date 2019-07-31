package com.codegym.model;

import javax.persistence.*;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project Blog
 * @Email:
 */
@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    public Blog() {
    }

    public Blog(int id, String title, String content) {
        this.setId ( id );
        this.setTitle ( title );
        this.setContent ( content );
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
