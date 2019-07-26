package com.codegym.model;

/**
 * @author Minh_Nguyen on  7/19/2019
 * @Project Login
 * @Email:
 */
public class Login {
    private String account;
    private String password;

    public Login() {
    }

    public Login(String account, String password) {
        this.setAccount(account);
        this.setPassword(password);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
