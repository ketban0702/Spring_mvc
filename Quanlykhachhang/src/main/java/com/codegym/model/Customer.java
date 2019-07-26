package com.codegym.model;

/**
 * @author Minh_Nguyen on  7/23/2019
 * @Project Customer
 * @Email:
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String email, String address) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
