package com.codegym.service;

import com.codegym.model.Employeetype;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeetypeService
 * @Email:
 */
public interface EmployeetypeService {
    Iterable<Employeetype> findAll();
    Employeetype findById(Long id);
    void save(Employeetype employeetype);
    void remove(Long id);
}
