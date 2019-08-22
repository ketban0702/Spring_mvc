package com.codegym.controller;

import com.codegym.model.Clazz;
import com.codegym.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project ClazzController
 * @Email:
 */
@Controller
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    //List clazz
    @GetMapping("/listclazz")
    public ModelAndView listClazz(Pageable pageable){
        Page<Clazz> clazzs =clazzService.findAll(pageable);
        ModelAndView modelAndView =new ModelAndView("/clazz/list");
        modelAndView.addObject("clazzs",clazzs);
        return modelAndView;
    }
    //Create-Clazz
    @GetMapping("/create-clazz")
    public ModelAndView createClazzForm(){
        ModelAndView modelAndView =new ModelAndView("/clazz/create");
        modelAndView.addObject("clazz",new Clazz());
        return modelAndView;
    }
    @PostMapping(value = "/create-clazz",produces = "application/json;charset=UTF-8")
    public ModelAndView createClazz(@ModelAttribute("clazz") Clazz clazz){
            clazzService.save(clazz);
            ModelAndView modelAndView=new ModelAndView("/clazz/create");
            modelAndView.addObject("clazz",clazz);
            modelAndView.addObject("message","Create clazz success");
            return modelAndView;
        }
}
