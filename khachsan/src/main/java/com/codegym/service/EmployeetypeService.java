package com.codegym.service;

import com.codegym.model.Employeetype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project EmployeetypeService
 * @Email:
 */
public interface EmployeetypeService {
    Page<Employeetype> findAll(Pageable pageable);

    Employeetype findById(Long id);

    void save(Employeetype employeetype);

    void remove(Long id);
}
