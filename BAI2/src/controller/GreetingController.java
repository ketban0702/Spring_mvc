package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Minh_Nguyen on  7/15/2019
 * @Project GreetingController
 * @Email:
 */

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }
    @GetMapping("/showName")
    public String showName(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        return "name";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
