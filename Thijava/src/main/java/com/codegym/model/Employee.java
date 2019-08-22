package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project Employee
 * @Email:
 */
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min=5,max = 100)
    private String fullname;
    @NotEmpty
    private String birthday;
    private String sex;
    @NotEmpty
    @Pattern(regexp ="^0(9|3|7|5|8)([0-9]{8})$")
    private String phone;
    @NotEmpty
    @Column(unique = true)
    @Size(min=9,max=12)
    @Pattern(regexp = "^1([0-9]{8,10})$")
    private String cmnd;
    @NotEmpty
    @Email
    @Column(unique = true)
    @Size(min=8,max=50)
    private String email;
    @NotEmpty
    @Size(min=5,max = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "employeetype_id")
    private Employeetype employeetype;
    public Employee() {
    }

    public Employee(@NotEmpty @Size(min = 5, max = 100) String fullname, @NotEmpty String birthday, String sex, @NotEmpty @Pattern(regexp = "^0(9|3|7|5|8)([0-9]{8})$") String phone, @NotEmpty @Size(min = 9, max = 12) @Pattern(regexp = "^1([0-9]{8,10})$") String cmnd, @NotEmpty @Email String email, @NotEmpty @Size(min = 5, max = 100) String address, Employeetype employeetype) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.setSex(sex);
        this.phone = phone;
        this.cmnd = cmnd;
        this.email = email;
        this.address = address;
        this.employeetype = employeetype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Employeetype getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(Employeetype employeetype) {
        this.employeetype = employeetype;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
