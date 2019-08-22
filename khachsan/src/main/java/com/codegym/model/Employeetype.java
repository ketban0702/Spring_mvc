package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project Employeetype
 * @Email:
 */
@Entity
@Table(name = "employeetype")
public class Employeetype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String group;
    @NotEmpty
    @Size(min = 5, max = 100)
    private String description;

    public Employeetype() {
    }

    public Employeetype(@NotEmpty @Size(min = 5, max = 100) String group, @NotEmpty @Size(min = 5, max = 100) String description) {
        this.setGroup(group);
        this.setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
