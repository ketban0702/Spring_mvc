package com.codegym.service.impl;

import com.codegym.model.Contact;
import com.codegym.repository.ContactRepository;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project ContactServiceImpl
 * @Email:
 */
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Iterable<Contact> findAll() {
        return null;
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact contact) {
    contactRepository.save(contact);
    }

    @Override
    public void remove(Long id) {
    contactRepository.delete(id);
    }

    @Override
    public Page<Contact> findAllByFirstnameContaining(String firstname, Pageable pageable) {
        return contactRepository.findAllByFirstnameContaining(firstname,pageable);
    }

    @Override
    public Page<Contact> findAllByFirstnameOrLastnameContaining(String firstname, String lastname, Pageable pageable) {
        return contactRepository.findAllByFirstnameOrLastnameContaining(firstname,lastname,pageable);
    }
}
