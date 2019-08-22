package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.Notetype;
import com.codegym.service.NoteService;
import com.codegym.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.Optional;

import static java.util.stream.Stream.of;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project NoteController
 * @Email:
 */
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NotetypeService notetypeService;
    @GetMapping("/notes")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining (s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home/notes");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
//    @GetMapping("/notes")
//    public ModelAndView listNote(Pageable pageable){
//        Page<Note> notes = noteService.findAll (pageable);
//        ModelAndView modelAndView = new ModelAndView("/note/list");
//        modelAndView.addObject("notes", notes);
//        return modelAndView;
//    }
    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveNote(@Validated @ModelAttribute("note") Note note, BindingResult bindingResult){
      if(bindingResult.hasFieldErrors ( )){
          ModelAndView modelAndView = new ModelAndView("/note/create");
          return modelAndView;
      }
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "New note created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@Valid @ModelAttribute("note") Note note, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors (  )){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            return modelAndView;
        }
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("note", note);
        modelAndView.addObject("message", "Note updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note")
    public String deleteNote(@ModelAttribute("note") Note note){
        noteService.remove(note.getId());
        return "redirect:notes";
    }
    @ModelAttribute("notetypes")
    public Page<Notetype> noteTypes(Pageable pageable){
        return notetypeService.findAll(pageable);
    }
}
