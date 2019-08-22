package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Minh_Nguyen on  8/1/2019
 * @Project UserController
 * @Email:
 */
@Controller
public class UserController {
   @Autowired
   private UserService userService;
    @GetMapping("/users")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("user", new User ());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {

            if (bindingResult.hasFieldErrors()) {
                ModelAndView modelAndView = new ModelAndView("/user/index");
                return modelAndView;
            }
            ModelAndView modelAndView = new ModelAndView("/user/result");
            return modelAndView;


    }
    @GetMapping("/register")
    public ModelAndView showFormRegister() {
        ModelAndView modelAndView = new ModelAndView( "/user/register" );
        modelAndView.addObject("user", new User ());
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView register(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        try {
            if (bindingResult.hasFieldErrors ()) {
                ModelAndView modelAndView = new ModelAndView ( "/user/register" );
                return modelAndView;
            }
            userService.save ( user );
            ModelAndView modelAndView = new ModelAndView ( "/user/register" );
            modelAndView.addObject ( "message", "Registor success" );
            modelAndView.addObject ( "user", new User () );
            return modelAndView;
        }catch (Exception ex){
            ModelAndView modelAndView = new ModelAndView( "/user/register" );
            modelAndView.addObject ( "message","UserName exits" );
            return modelAndView;
        }
    }
    @GetMapping("/login")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        modelAndView.addObject("user", new User ());
        return modelAndView;
    }
    @PostMapping("/login")
    public String login1(@ModelAttribute("user") User user, Model model){
        User user1=userService.findByUsername ( user.getUsername () );
        if((user1 !=null)&&(user.getPassword ().equals ( user1.getPassword () ))){
            return "redirect:notes";
        }else {
            return "/home/error";
        }
    }
}
