package com.codegym.cms.service;

import com.codegym.cms.model.Province;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project ProvinceService
 * @Email:
 */
public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
