package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

/**
 * @author Minh_Nguyen on  7/23/2019
 * @Project CustomerService
 * @Email:
 */
public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
