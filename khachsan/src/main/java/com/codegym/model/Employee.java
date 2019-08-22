package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project Employee
 * @Email:
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 5,max = 50)
    private String name;
    @NotEmpty
    private Date birthday;
    @NotEmpty
    private boolean sex;
    @NotEmpty
    private String phone;
    @NotEmpty
    @Size(min=9,max = 12)
    private String cmnd;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    @ManyToOne
    @JoinColumn(name = "employeetype_id")
    private Employeetype employeetype;

    public Employee() {
    }

    public Employee(@NotEmpty @Size(min = 5, max = 50) String name, @NotEmpty Date birthday, @NotEmpty boolean sex, @NotEmpty String phone, @NotEmpty @Size(min = 9, max = 12) String cmnd, @NotEmpty String email, @NotEmpty String address) {
        this.setName(name);
        this.setBirthday(birthday);
        this.setSex(sex);
        this.setPhone(phone);
        this.setCmnd(cmnd);
        this.setEmail(email);
        this.setAddress(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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
