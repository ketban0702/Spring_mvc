package com.boraji.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Minh_Nguyen on  7/23/2019
 * @Project MyController
 * @Email:
 */
@Controller
public class MyController {
    @GetMapping("/home")
    public String index(Model model) {

        model.addAttribute("message", "Hello Spring MVC 5!");
        return "index";
    }
}
