package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Minh_Nguyen on  7/19/2019
 * @Project HomeController
 * @Email:
 */
@Controller
public class HomeController {
  @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String sayHello(){
      return "hello";
  }
}
