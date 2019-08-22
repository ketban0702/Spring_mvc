package com.codegym.service.impl;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteServiceImpl
 * @Email:
 */
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Page<Note> findAll(Pageable pageable) {
        pageable=new PageRequest(pageable.getPageNumber (), 5);
        return noteRepository.findAll (pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findOne ( id );
    }

    @Override
    public void save(Note note) {
    noteRepository.save ( note );
    }

    @Override
    public void remove(Long id) {
    noteRepository.delete ( id );
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        pageable=new PageRequest(pageable.getPageNumber (), 5);
        return noteRepository.findAllByTitleContaining ( title, pageable );
    }
}
