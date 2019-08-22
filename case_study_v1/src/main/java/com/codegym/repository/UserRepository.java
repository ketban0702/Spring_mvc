package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Minh_Nguyen on  8/1/2019
 * @Project UserRepository
 * @Email:
 */
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByUsername(String username);
}
