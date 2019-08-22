package com.codegym.controller;

import com.codegym.model.Contact;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author Minh_Nguyen on  8/15/2019
 * @Project ContactController
 * @Email:
 */
@Controller
public class ContactController {
@Autowired
    private ContactService contactService;
    //Hien thi List
    @GetMapping("/list")
    public ModelAndView showList(Pageable pageable) {
        Page<Contact> listContact = contactService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts", listContact);
        return modelAndView;
    }
    //Creat-Contact
    @GetMapping("/create-contact")
    public ModelAndView createContactForm() {
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }
    @PostMapping(value = "/create-contact", produces = "application/json;charset=UTF-8")
    public ModelAndView createContact(@Validated @ModelAttribute("contact") Contact contact, BindingResult bindingResult) throws Exception {
              try {
                  if(bindingResult.hasErrors()){
                      ModelAndView modelAndView = new ModelAndView("/contact/create");
                      return modelAndView;
                  }else {
                      contactService.save(contact);
                      ModelAndView modelAndView = new ModelAndView("/contact/create");
                      modelAndView.addObject("message", "Create contact success");
                      modelAndView.addObject("contact", new Contact());
                      return modelAndView;
                  }
              }catch (Exception ex){
                  ModelAndView modelAndView = new ModelAndView("/contact/create");
                  modelAndView.addObject("message1", " Field is exits");
                  return modelAndView;
              }
    }
    //Edit-contact
    @GetMapping("/edit-contact/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/edit");
            modelAndView.addObject("contact", contact);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping(value = "/edit-contact", produces = "application/json;charset=UTF-8")
    public ModelAndView editStudent(@Validated @ModelAttribute("contact") Contact contact, Pageable pageable, BindingResult bindingResult) throws Exception {
              try {
                  if(bindingResult.hasErrors()){
                      ModelAndView modelAndView = new ModelAndView("/contact/edit");
                      return modelAndView;
                  }else {
                      contactService.save(contact);
                      Page<Contact> listContact = contactService.findAll(pageable);
                      ModelAndView modelAndView = new ModelAndView("/contact/list");
                      modelAndView.addObject("contacts", listContact);
                      modelAndView.addObject("message", "Update success");
                      return modelAndView;
                  }
              }catch (Exception ex){
                  ModelAndView modelAndView = new ModelAndView("/contact/edit");
                  modelAndView.addObject("message1", " Field is exits");
                  return modelAndView;
              }
    }
    //Delete-contact
    @GetMapping("/delete-contact/{id}")
    public ModelAndView deleteContactForm(@PathVariable("id") Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/delete");
            modelAndView.addObject("contact", contact);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            modelAndView.addObject("contact", contact);
            return modelAndView;
        }
    }

    @PostMapping(value = "/delete-contact", produces = "application/json;charset=UTF-8")
    public String deleteContact(@ModelAttribute("contact") Contact contact) {
        contactService.remove(contact.getId());
        return "redirect:list";
    }
    //Search
//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam("search") String search, Pageable pageable) {
//        Page<Contact> contacts = contactService.findAllByFirstnameContaining(search, pageable);
//        ModelAndView modelAndView = new ModelAndView("/contact/list");
//        modelAndView.addObject("contacts", contacts);
//        return modelAndView;
//    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Contact> contacts = contactService.findAllByFirstnameOrLastnameContaining(search.get(),search.get(), pageable);
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }
}
