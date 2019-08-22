package com.codegym.service;

import com.codegym.model.Clazz;
import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project StudentService
 * @Email:
 */
public interface StudentService {
    Page<Student> findAll(Pageable pageable);
    Iterable<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void remove(Long id);
}
