package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project BlogService
 * @Email:
 */
public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
