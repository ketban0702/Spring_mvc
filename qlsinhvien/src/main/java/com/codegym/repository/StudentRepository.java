package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project StudentRepository
 * @Email:
 */
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
}
