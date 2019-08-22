package com.codegym.repository;

import com.codegym.model.Notetype;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteTypeRepository
 * @Email:
 */
public interface NotetypeRepository extends PagingAndSortingRepository<Notetype,Long> {
}
