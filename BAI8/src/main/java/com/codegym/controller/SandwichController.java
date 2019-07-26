package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Minh_Nguyen on  7/21/2019
 * @Project SandwichController
 * @Email:
 */
@Controller
public class SandwichController {
    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/detail",method = RequestMethod.POST)
public String home(@RequestParam("favorite") String[] favorite, Model model){
        model.addAttribute("listFavorite",favorite);
        return "detail";
    }
}
