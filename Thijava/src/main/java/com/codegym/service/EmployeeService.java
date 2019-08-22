package com.codegym.service;


import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeeService
 * @Email:
 */
public interface EmployeeService {
    Page<Employee>findAll(Pageable pageable);
    Iterable<Employee> findAll();
    Employee findById(Long id);
    void save(Employee employee);
    void remove(Long id);
    Page<Employee>findAllByFullnameContaining(String fullname,Pageable pageable);
    Iterable<Employee>findAllByFullnameContaining(String fullname);
}
