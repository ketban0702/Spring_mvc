package com.codegym.cms.service.impl;

import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ProvinceRepository;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project ProvinceServiceImpl
 * @Email:
 */
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll ();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne ( id );
    }

    @Override
    public void save(Province province) {
    provinceRepository.save ( province );
    }

    @Override
    public void remove(Long id) {
    provinceRepository.delete ( id );
    }
}
