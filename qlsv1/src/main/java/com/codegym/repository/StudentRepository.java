package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project StudentRepository
 * @Email:
 */
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    Page<Student> findAllByFullnameContaining(String fullname, Pageable pageable);
}
