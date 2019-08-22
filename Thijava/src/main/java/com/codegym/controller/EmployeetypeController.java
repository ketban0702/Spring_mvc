package com.codegym.controller;

import com.codegym.model.Employeetype;
import com.codegym.repository.EmployeetypeRepository;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeetypeController
 * @Email:
 */
@Controller
public class EmployeetypeController {

    @Autowired
    private EmployeetypeRepository employeetypeRepository;
    //List Employeetype
    @GetMapping("/listemployeetype")
    public ModelAndView listEmployeetype(){
        Iterable<Employeetype> employeetypes=employeetypeRepository.findAll();
        ModelAndView modelAndView =new ModelAndView("/employeetype/list");
        modelAndView.addObject("employeetypes",employeetypes);
        return modelAndView;
    }

    //Create-Employeetype
    @GetMapping("/create-employeetype")
    public ModelAndView createEmployeetypeForm(){
        ModelAndView modelAndView =new ModelAndView("/employeetype/create");
        modelAndView.addObject("employeetype",new Employeetype());
        return modelAndView;
    }
//    @PostMapping("/create-employeetype")
    @PostMapping(value = "/create-employeetype",produces = "application/json;charset=UTF-8")
    public ModelAndView createEmployeetype(@ModelAttribute("employeetype") Employeetype employeetype, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("/employeetype/create");
            return modelAndView;
        }else{
            employeetypeRepository.save(employeetype);//Save vao csdl
            ModelAndView modelAndView=new ModelAndView("/employeetype/create");
            modelAndView.addObject("employeetype",employeetype);
            modelAndView.addObject("message","Create employeetype success");
            return modelAndView;
        }
    }
    //Edit-Employeetype
    @GetMapping("/edit-employeetype/{id}")
    public ModelAndView editEmployeetypeForm(@PathVariable("id") Long id){
        Employeetype employeetype=employeetypeRepository.findOne(id);
        if(employeetype !=null){
            ModelAndView modelAndView=new ModelAndView("/employeetype/edit");
            modelAndView.addObject("employeetype",employeetype);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/error404");
            return modelAndView;
        }
    }
//    @PostMapping("/edit-employeetype")
    @PostMapping(value = "/edit-employeetype",produces = "application/json;charset=UTF-8")
    public ModelAndView editEmployeetype(@ModelAttribute("employeetype") Employeetype employeetype, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("/employeetype/edit");
            return modelAndView;
        }else {
            employeetypeRepository.save(employeetype);
            ModelAndView modelAndView=new ModelAndView("/employeetype/edit");
            modelAndView.addObject("employeetype",employeetype);
            modelAndView.addObject("message","Update employeetype success");
            return modelAndView;
        }
    }
    //Delete-Employee
    @GetMapping("/delete-employeetype/{id}")
    public ModelAndView deleteEmployeetypeForm(@PathVariable("id") Long id){
        Employeetype employeetype=employeetypeRepository.findOne(id);
        if(employeetype !=null){
            ModelAndView modelAndView=new ModelAndView("/employeetype/delete");
            modelAndView.addObject("employeetype",employeetype);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/error404");
            return modelAndView;
        }
    }
//    @PostMapping("/delete-employeetype")
    @PostMapping(value = "/delete-employeetype",produces = "application/json;charset=UTF-8")
    public String deleteEmployeetype(@ModelAttribute("employeetype") Employeetype employeetype){
        employeetypeRepository.delete(employeetype.getId());
        return "redirect:listemployeetype";
    }
}
