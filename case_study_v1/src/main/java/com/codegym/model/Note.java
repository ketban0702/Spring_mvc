package com.codegym.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project Note
 * @Email:
 */
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=5,max=200)
    private String title;

    @NotEmpty
    @Size(min=5,max=200)
    private String content;

    @ManyToOne
    @JoinColumn(name = "notetype_id")
    private Notetype notetype;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;

    @UpdateTimestamp
    private Date dateEditor;

    public Note() {
    }

    public Note(@NotEmpty @Size(min = 5, max = 200) String title, @NotEmpty @Size(min = 5, max = 200) String content, Notetype notetype, Date dateCreate, Date dateEditor) {
        this.title = title;
        this.content = content;
        this.notetype = notetype;
        this.dateCreate = dateCreate;
        this.dateEditor = dateEditor;
    }

    public Note(String title, String content) {
        this.setTitle ( title );
        this.setContent ( content );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Notetype getNotetype() {
        return notetype;
    }

    public void setNotetype(Notetype notetype) {
        this.notetype = notetype;
    }

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateEditor() {
        return dateEditor;
    }

    public void setDateEditor(Date dateEditor) {
        this.dateEditor = dateEditor;
    }
}
