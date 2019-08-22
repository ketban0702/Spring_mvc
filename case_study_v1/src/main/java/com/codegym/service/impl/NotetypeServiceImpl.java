package com.codegym.service.impl;

import com.codegym.model.Notetype;
import com.codegym.repository.NotetypeRepository;
import com.codegym.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteTypeServiceImpl
 * @Email:
 */
public class NotetypeServiceImpl implements NotetypeService {

    @Autowired
    private NotetypeRepository notetypeRepository;
    @Override
    public Page<Notetype> findAll(Pageable pageable) {
        return notetypeRepository.findAll (pageable);
    }

    @Override
    public Notetype findById(Long id) {
        return notetypeRepository.findOne ( id );
    }

    @Override
    public void save(Notetype noteType) {
    notetypeRepository.save ( noteType );
    }

    @Override
    public void remove(Long id) {
    notetypeRepository.delete ( id );
    }
}
