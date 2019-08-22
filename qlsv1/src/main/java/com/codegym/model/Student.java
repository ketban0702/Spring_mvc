package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project Student
 * @Email:
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=5,max=100,message = "toi thieu 5 ky tu, toi da 100 ky tu")
    private String code;
    private String clazzcode;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min=5,max=200,message = "toi thieu 5 ky tu, toi da 200 ky tu")
    private String fullname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    private String sex;
    @NotEmpty(message = "Khong duoc de trong")
    @Column(unique = true)
    @Size(min=9,max=12,message = "toi thieu 9 ky tu, toi da 12 ky tu")
    @Pattern(regexp = "^1([0-9]{8,10})$",message = "So cmnd gom 8 den 10 so, bat dau bang so 1")
    private String cmnd;
    @NotEmpty(message = "Khong duoc de trong")
    @Pattern(regexp ="^0(9|3|7|5|8)([0-9]{8})$",message = "So dien thoai gom 10 so, bat dau bang 09,03,07,05,08 va 8 so tiep theo tu 0 den 9")
    private String phone;
    @NotEmpty(message = "Khong duoc de trong")
    @Email
    @Column(unique = true)
    @Size(min=8,max=50,message = "email toi thieu 8 ky tu, toi da 50 ky tu")
    private String email;

    public Student() {
    }

    public Student(@NotEmpty @Size(min = 5, max = 100) String code, String clazzcode, @NotEmpty @Size(min = 5, max = 200) String fullname, @Past LocalDate birthday, String sex, @NotEmpty @Size(min = 9, max = 12) @Pattern(regexp = "^1([0-9]{8,10})$") String cmnd, @NotEmpty @Pattern(regexp = "^0(9|3|7|5|8)([0-9]{8})$") String phone, @NotEmpty @Email @Size(min = 8, max = 50) String email) {
        this.code = code;
        this.clazzcode = clazzcode;
        this.fullname = fullname;
        this.birthday = birthday;
        this.sex = sex;
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

    public String getClazzcode() {
        return clazzcode;
    }

    public void setClazzcode(String clazzcode) {
        this.clazzcode = clazzcode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
