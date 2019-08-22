package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.ClazzService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Minh_Nguyen on  8/14/2019
 * @Project StudentController
 * @Email:
 */
@Controller
public class StudentController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;

    //Hien thi List
    @GetMapping("/list")
    public ModelAndView showList(Pageable pageable) {
        Page<Student> listStudent = studentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", listStudent);
        return modelAndView;
    }

    //Creat-Employee
    @GetMapping("/create-student")
    public ModelAndView createStudentForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping(value = "/create-student", produces = "application/json;charset=UTF-8")
    public ModelAndView createStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("message", "Create student success");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    //Edit-student
    @GetMapping("/edit-student/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/edit-student", produces = "application/json;charset=UTF-8")
    public ModelAndView editStudent(@ModelAttribute("student") Student student, Pageable pageable) throws Exception {
        studentService.save(student);
        Page<Student> listStudent = studentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", listStudent);
        modelAndView.addObject("message", "Update success");
        return modelAndView;
    }
    //Delete-Employee
    @GetMapping("/delete-student/{id}")
    public ModelAndView deleteStudentForm(@PathVariable("id") Long id){
        Student student = studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            modelAndView.addObject("student", student);
            return modelAndView;
        }
    }

    @PostMapping(value = "/delete-student", produces = "application/json;charset=UTF-8")
    public String deleteStudent(@ModelAttribute("student") Student student){
        studentService.remove(student.getId());
        return "redirect:list";
    }
}
