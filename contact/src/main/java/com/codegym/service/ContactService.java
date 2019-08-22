package com.codegym.service;

import com.codegym.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project ContactService
 * @Email:
 */
public interface ContactService {
    Page<Contact> findAll(Pageable pageable);
    Iterable<Contact> findAll();
    Contact findById(Long id);
    void save(Contact contact);
    void remove(Long id);
    Page<Contact> findAllByFirstnameContaining(String firstname, Pageable pageable);
    Page<Contact> findAllByFirstnameOrLastnameContaining(String firstname, String lastname, Pageable pageable);
}
