package com.codegym.repository;

import com.codegym.model.Employeetype;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeetypeRepository
 * @Email:
 */
public interface EmployeetypeRepository extends PagingAndSortingRepository<Employeetype,Long> {
}
