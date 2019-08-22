package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project Employeetype
 * @Email:
 */
@Entity
@Table(name = "employeetypes")
public class Employeetype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min=5,max=100)
    private String description;

    @OneToMany(mappedBy = "employeetype")
    private Set<Employee> employees ;


    public Employeetype() {
    }

    public Employeetype(Long id, String description) {
        this.setId(id);
        this.setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
