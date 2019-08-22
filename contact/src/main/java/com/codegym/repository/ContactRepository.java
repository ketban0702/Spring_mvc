package com.codegym.repository;

import com.codegym.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project ContactRepository
 * @Email:
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {
    Page<Contact> findAllByFirstnameContaining(String firstname, Pageable pageable);
    Page<Contact> findAllByFirstnameOrLastnameContaining(String firstname, String lastname, Pageable pageable);
}
