package com.codegym.service.impl;

import com.codegym.model.Clazz;
import com.codegym.repository.ClazzRepository;
import com.codegym.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project ClazzServiceImpl
 * @Email:
 */
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository clazzRepository;
    @Override
    public Page<Clazz> findAll(Pageable pageable) {
        return clazzRepository.findAll(pageable);
    }

    @Override
    public Iterable<Class> findAll() {
        return null;
    }

    @Override
    public Clazz findById(Long id) {
        return clazzRepository.findOne(id);
    }

    @Override
    public void save(Clazz clazz) {
    clazzRepository.save(clazz);
    }

    @Override
    public void remove(Long id) {
    clazzRepository.delete(id);
    }
}
