package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project Clazz
 * @Email:
 */
@Entity
@Table(name = "clazz")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "clazz")
    private Set<Student> students ;

    public Clazz() {
    }

    public Clazz(Long id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
