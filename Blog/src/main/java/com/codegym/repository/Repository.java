package com.codegym.repository;

import java.util.List;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project Repository
 * @Email:
 */
public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
