package com.codegym.service;

import com.codegym.model.Note;
import com.codegym.model.Notetype;
import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/1/2019
 * @Project UserService
 * @Email:
 */
public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User user);

    void remove(Long id);

    User findByUsername(String username);
}
