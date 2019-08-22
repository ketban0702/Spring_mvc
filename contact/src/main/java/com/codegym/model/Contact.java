package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project Contact
 * @Email:
 */
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=2,max=100,message = "toi thieu 5 ky tu, toi da 100 ky tu")
    private String firstname;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=2,max=100,message = "toi thieu 5 ky tu, toi da 100 ky tu")
    private String lastname;
    @NotEmpty(message = "Khong duoc de trong")
    @Pattern(regexp ="^0(9|3|7|5|8)([0-9]{8})$",message = "So dien thoai gom 10 so, bat dau bang 09,03,07,05,08 va 8 so tiep theo tu 0 den 9")
    private String phone;
    @NotEmpty(message = "Khong duoc de trong")
    @Email
    @Column(unique = true)
    @Size(min=8,max=50,message = "email toi thieu 8 ky tu, toi da 50 ky tu")
    private String email;
    @NotEmpty(message = "Khong duoc de trong")
    private String address;

    public Contact() {
    }

    public Contact(@NotEmpty(message = "Khong duoc de trong") @Size(min = 2, max = 100, message = "toi thieu 5 ky tu, toi da 100 ky tu") String firstname, @NotEmpty(message = "Khong duoc de trong") @Size(min = 2, max = 100, message = "toi thieu 5 ky tu, toi da 100 ky tu") String lastname, @NotEmpty(message = "Khong duoc de trong") @Pattern(regexp = "^0(9|3|7|5|8)([0-9]{8})$", message = "So dien thoai gom 10 so, bat dau bang 09,03,07,05,08 va 8 so tiep theo tu 0 den 9") String phone, @NotEmpty(message = "Khong duoc de trong") @Email @Size(min = 8, max = 50, message = "email toi thieu 8 ky tu, toi da 50 ky tu") String email, @NotEmpty(message = "Khong duoc de trong") String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
