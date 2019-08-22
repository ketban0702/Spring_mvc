package com.codegym.service.impl;

import com.codegym.model.Employeetype;
import com.codegym.repository.EmployeetypeRepository;
import com.codegym.service.EmployeetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project EmployeetypeServiceImpl
 * @Email:
 */
public class EmployeetypeServiceImpl implements EmployeetypeService {
    @Autowired
    private EmployeetypeRepository employeetypeRepository;
    @Override
    public Page<Employeetype> findAll(Pageable pageable) {
        return employeetypeRepository.findAll(pageable);
    }

    @Override
    public Employeetype findById(Long id) {
        return employeetypeRepository.findOne(id);
    }

    @Override
    public void save(Employeetype employeetype) {
    employeetypeRepository.save(employeetype);
    }

    @Override
    public void remove(Long id) {
    employeetypeRepository.delete(id);
    }
}
