package com.codegym.service;

import com.codegym.model.Notetype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteTypeService
 * @Email:
 */
public interface NotetypeService {

    Page<Notetype> findAll(Pageable pageable);

    Notetype findById(Long id);

    void save(Notetype noteType);

    void remove(Long id);
}
