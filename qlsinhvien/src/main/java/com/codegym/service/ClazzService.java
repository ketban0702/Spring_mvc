package com.codegym.service;

import com.codegym.model.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project ClazzService
 * @Email:
 */
public interface ClazzService {
    Page<Clazz> findAll(Pageable pageable);
    Iterable<Class> findAll();
    Clazz findById(Long id);
    void save(Clazz clazz);
    void remove(Long id);
}
