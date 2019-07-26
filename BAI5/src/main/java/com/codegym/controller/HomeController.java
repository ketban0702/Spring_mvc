package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Minh_Nguyen on  7/19/2019
 * @Project HomeController
 * @Email:
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home","login",new Login());
        return modelAndView;
    }
    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login){
        User user = UserDao.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView =new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("user");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
    }
}
