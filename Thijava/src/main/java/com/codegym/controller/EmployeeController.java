package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.Employeetype;
import com.codegym.repository.EmployeeRepository;
import com.codegym.repository.EmployeetypeRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Set;

/**
 * @author Minh_Nguyen on  8/12/2019
 * @Project EmployeeController
 * @Email:
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeetypeRepository employeetypeRepository;

    //Hien thi List
    @GetMapping("/listemployee")
    public ModelAndView showList(Pageable pageable) {
        Page<Employee> listEmployee=employeeRepository.findAll(pageable);
//        Iterable<Employee> listEmployee = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/list2");
        modelAndView.addObject("employees", listEmployee);
        return modelAndView;
    }

    //Search
    @PostMapping ("/search")
    public ModelAndView search(@RequestParam("search") String search, Pageable pageable){
        Page<Employee> employees=employeeRepository.findAllByFullnameContaining(search,pageable);
//        Iterable<Employee> employees=employeeRepository.findAllByFullnameContaining(search);
        ModelAndView modelAndView = new ModelAndView("/employee/list2");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    //ModelAttribute
    @ModelAttribute("employeetypes")
    public Iterable<Employeetype> employeetypes() {
        return employeetypeRepository.findAll();
    }

    //Creat-Employee
    @GetMapping("/create-employee")
    public ModelAndView createEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create2");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    //    @PostMapping("/create-employee")
    @PostMapping(value = "/create-employee", produces = "application/json;charset=UTF-8")
    public ModelAndView createEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                ModelAndView modelAndView = new ModelAndView("/employee/create2");
                return modelAndView;
            }
            employeeRepository.save(employee);//Luu employee vao csdl
            ModelAndView modelAndView = new ModelAndView("/employee/create2");
            modelAndView.addObject("message", "Create employee success");
            modelAndView.addObject("employee", new Employee());
            return modelAndView;
        } catch (Exception ex) {
            ModelAndView modelAndView = new ModelAndView("/employee/create2");
            modelAndView.addObject("message1", " Field is exits");
            return modelAndView;
        }
    }

    //Edit-employee
    @GetMapping("/edit-employee/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findOne(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    //    @PostMapping("/edit-employee")
    @PostMapping(value = "d", produces = "application/json;charset=UTF-8")
    public ModelAndView editEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                ModelAndView modelAndView = new ModelAndView("/employee/edit");
                return modelAndView;
            } else {
                employeeRepository.save(employee);
                Iterable<Employee> listEmployee = employeeRepository.findAll();
                ModelAndView modelAndView = new ModelAndView("/employee/list2");
                modelAndView.addObject("employees", listEmployee);
                modelAndView.addObject("message", "Update success");
                return modelAndView;
            }
        }catch (Exception ex) {
                ModelAndView modelAndView = new ModelAndView("/employee/edit");
                modelAndView.addObject("message1", " Field is exits");
                return modelAndView;
            }
        }

        //Delete-Employee
        @GetMapping("/delete-employee/{id}")
        public ModelAndView deleteEmployeeForm (@PathVariable("id") Long id){
            Employee employee = employeeRepository.findOne(id);
            if (employee != null) {
                ModelAndView modelAndView = new ModelAndView("/employee/delete");
                modelAndView.addObject("employee", employee);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error404");
                modelAndView.addObject("employee", employee);
                return modelAndView;
            }
        }

        //    @PostMapping("/delete-employee")
        @PostMapping(value = "/delete-employee", produces = "application/json;charset=UTF-8")
        public String deleteEmployee (@ModelAttribute("employee") Employee employee){
            employeeRepository.delete(employee.getId());
            return "redirect:listemployee";
        }
    }
