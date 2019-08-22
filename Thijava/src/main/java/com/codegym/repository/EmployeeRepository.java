package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeeRepository
 * @Email:
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee>findAllByFullnameContaining(String fullname,Pageable pageable);
    Iterable<Employee>findAllByFullnameContaining(String fullname);

}
