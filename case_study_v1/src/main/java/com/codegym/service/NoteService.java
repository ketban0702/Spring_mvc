package com.codegym.service;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteService
 * @Email:
 */
public interface NoteService {

    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
