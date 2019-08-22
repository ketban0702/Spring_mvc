package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import com.codegym.service.EmployeetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author Minh_Nguyen on  8/9/2019
 * @Project EmployeeController
 * @Email:
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeetypeService employeetypeService;
    @GetMapping("/employees")
    public ModelAndView listCustomers(Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

}
