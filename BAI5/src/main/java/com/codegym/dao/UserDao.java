package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Minh_Nguyen on  7/19/2019
 * @Project UserDao
 * @Email:
 */
public class UserDao {
    private static List<User> user;
    static {
        user=new ArrayList<User>();
        User user1=new User();
        user1.setAge(10);
        user1.setName("John");
        user1.setAccount("john");
        user1.setEmail("john@codegym.vn");
        user1.setPassword("123456");
        user.add(user1);

        User user2=new User();
        user2.setAge(15);
        user2.setName("Bill");
        user2.setAccount("bill");
        user2.setEmail("bill@codegym.vn");
        user2.setPassword("123456");
        user.add(user2);

        User user3=new User();
        user3.setAge(16);
        user3.setName("Mike");
        user3.setAccount("mike");
        user3.setEmail("mike@codegym.vn");
        user3.setPassword("123456");
        user.add(user3);
    }

    public static User checkLogin( Login login){
        for(User users:user){
            if((users.getAccount().equals(login.getAccount()))&&(users.getPassword().equals(login.getPassword()))){
                return users;
            }
        }
        return null;
    }
}
