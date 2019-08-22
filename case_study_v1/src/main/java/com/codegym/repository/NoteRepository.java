package com.codegym.repository;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteRepository
 * @Email:
 */
public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
