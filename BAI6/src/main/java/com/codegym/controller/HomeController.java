package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Minh_Nguyen on  7/21/2019
 * @Project HomeController
 * @Email:
 */
@Controller
public class HomeController {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public HomeController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String user(@RequestParam("email") String email, Model model) {
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
            return "home";
        }
        model.addAttribute("email", email);
        return "success";
    }
    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
