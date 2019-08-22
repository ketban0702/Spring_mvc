package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project EmployeeService
 * @Email:
 */
public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);
   // Page<Employee> findAllByTitleContaining(String title, Pageable pageable);
}
