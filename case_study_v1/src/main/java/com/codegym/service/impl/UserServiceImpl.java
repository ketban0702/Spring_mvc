package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Minh_Nguyen on  8/1/2019
 * @Project UserServiceImpl
 * @Email:
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll ( pageable );
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne ( id );
    }

    @Override
    public void save(User user) {
    userRepository.save ( user );
    }

    @Override
    public void remove(Long id) {
    userRepository.delete ( id );
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername ( username );
    }

}
