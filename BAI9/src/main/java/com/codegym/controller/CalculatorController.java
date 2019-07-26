package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Minh_Nguyen on  7/21/2019
 * @Project CalculatorController
 * @Email:
 */
@Controller
public class CalculatorController {
    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/homes", params = "add", method = RequestMethod.POST)
    public String homes(@RequestParam("number1") String number1, @RequestParam("number2") String number2, Model model) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        model.addAttribute("result", num1 + num2);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "home";
    }

    @RequestMapping(value = "/homes", params = "sub", method = RequestMethod.POST)
    public String homes1(@RequestParam("number1") String number1, @RequestParam("number2") String number2, Model model) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        model.addAttribute("result", num1 - num2);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "home";
    }
    @RequestMapping(value = "/homes", params = "mul", method = RequestMethod.POST)
    public String homes2(@RequestParam("number1") String number1, @RequestParam("number2") String number2, Model model) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        model.addAttribute("result", num1 * num2);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "home";
    }
    @RequestMapping(value = "/homes", params = "div", method = RequestMethod.POST)
    public String homes3(@RequestParam("number1") String number1, @RequestParam("number2") String number2, Model model) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        if(num2 !=0){
            model.addAttribute("result",num1/num2);
        }else {
            model.addAttribute("result1","Pls replace number2 for division");
        }
        return "home";
    }
}
