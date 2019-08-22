package com.codegym.controller;

import com.codegym.model.Notetype;
import com.codegym.service.NotetypeService;
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
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteTypeController
 * @Email:
 */
@Controller
public class NotetypeController {

    @Autowired
    private NotetypeService notetypeService;

    @GetMapping("/notetypes")
    public ModelAndView listNotetype(Pageable pageable) {
        Page<Notetype> notetypes = notetypeService.findAll (pageable);
        ModelAndView modelAndView = new ModelAndView ( "/home/notetype" );
        modelAndView.addObject ( "notetypes", notetypes );
        return modelAndView;
    }
    @GetMapping("/create-notetype")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/notetype/create");
        modelAndView.addObject("notetype", new Notetype ());
        return modelAndView;
    }

    @PostMapping("/create-notetype")
    public ModelAndView saveNotetype(@Validated @ModelAttribute("notetype") Notetype notetype, BindingResult bindingResult){
       if(bindingResult.hasFieldErrors (  )) {
           ModelAndView modelAndView = new ModelAndView ( "/notetype/create" );
           return modelAndView;
       }
        notetypeService.save ( notetype );
        ModelAndView modelAndView = new ModelAndView ( "/notetype/create" );
        modelAndView.addObject ( "notetype", new Notetype () );
        modelAndView.addObject ( "message", "New notetype created successfully" );
        return modelAndView;
    }
    @GetMapping("/edit-notetype/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Notetype notetype = notetypeService.findById(id);
        if(notetype != null) {
            ModelAndView modelAndView = new ModelAndView("/notetype/edit");
            modelAndView.addObject("notetype", notetype);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-notetype")
    public ModelAndView updateNotetype(@ModelAttribute("notetype") Notetype notetype){
        notetypeService.save(notetype);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("notetype", notetype);
        modelAndView.addObject("message", "Notetype updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-notetype/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Notetype notetype = notetypeService.findById(id);
        if(notetype != null) {
            ModelAndView modelAndView = new ModelAndView("/notetype/delete");
            modelAndView.addObject("notetype", notetype);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-notetype")
    public String deleteNotetype(@ModelAttribute("notetype") Notetype notetype){
        notetypeService.remove(notetype.getId());
        return "redirect:notetypes";
    }
}
