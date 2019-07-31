package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Minh_Nguyen on  7/31/2019
 * @Project BlogController
 * @Email:
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView ( "/blog/create" );
        modelAndView.addObject ( "blog", new Blog () );
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save ( blog );
        ModelAndView modelAndView = new ModelAndView ( "/blog/create" );
        modelAndView.addObject ( "blog", new Blog () );
        modelAndView.addObject ( "message", "New customer created successfully" );
        return modelAndView;
    }

    @GetMapping("/blog")
    public ModelAndView listBlog() {
        List<Blog> blogs = blogService.findAll ();
        ModelAndView modelAndView = new ModelAndView ( "/blog/list" );
        modelAndView.addObject ( "blogs", blogs );
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById ( id );
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView ( "/blog/edit" );
            modelAndView.addObject ( "blog", blog );
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView ( "/error.404" );
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save ( blog );
        ModelAndView modelAndView = new ModelAndView ( "/blog/edit" );
        modelAndView.addObject ( "blog", blog );
        modelAndView.addObject ( "message", "Customer updated successfully" );
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById ( id );
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView ( "/blog/delete" );
            modelAndView.addObject ( "blog", blog );
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView ( "/error.404" );
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove ( blog.getId () );
        return "redirect:blog";
    }
}
