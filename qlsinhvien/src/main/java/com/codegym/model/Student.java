package com.codegym.model;

import javax.persistence.*;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project Student
 * @Email:
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String fullname;
    private String birthday;
    private String sex;
    private String cmnd;
    private String phone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;
    public Student() {
    }


    public Student(Long id, String code, String fullname, String birthday, String sex, String cmnd, String phone, String email) {
        this.id = id;
        this.code = code;
        this.fullname = fullname;
        this.birthday = birthday;
        this.setSex(sex);
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
