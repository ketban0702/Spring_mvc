package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Minh_Nguyen on  7/16/2019
 * @Project ConvertTeampleController
 * @Email:
 */
@Controller
public class ConvertTeampleController {
    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public String convertTeamples(){
        return "home";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String convertTeample(@RequestParam String inputName, Model model){

        double convert=Double.parseDouble(inputName)*20000;
        model.addAttribute("inputName",inputName);
        model.addAttribute("convert",convert);
        return "home";
    }
}
