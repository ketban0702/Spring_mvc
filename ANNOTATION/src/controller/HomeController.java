package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Minh_Nguyen on  7/17/2019
 * @Project HomeController
 * @Email:
 */
@Controller
public class HomeController {
    //    @RequestMapping(value="/test",method = RequestMethod.GET)
//    public String doGet(){
//        return "home";
//    }
//    @RequestMapping(value="/test1",method = RequestMethod.GET)
//    public String doPost(){
//        return "home2";
//    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String home() {
        return "form";
    }
    @RequestMapping(value = "/sent",method = RequestMethod.POST)
    public String send(@RequestParam (value = "inputName") String inputName,
                       @RequestParam (value = "inputAge") String inputAge,Model model){
        model.addAttribute("name",inputName);
        model.addAttribute("name1",inputName);
        model.addAttribute("age",inputAge);
        model.addAttribute("age1",inputAge);
        return "form";
    }


}
