package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeeServiceImpl
 * @Email:
 */
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Page<Employee> findAllByFullnameContaining(String fullname, Pageable pageable) {
        return employeeRepository.findAllByFullnameContaining(fullname,pageable);
    }

    @Override
    public Iterable<Employee> findAllByFullnameContaining(String fullname) {
        return employeeRepository.findAllByFullnameContaining(fullname);
    }

}
