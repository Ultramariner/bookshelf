package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.myProjects.bookshelf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

    private final GenreService genreService;
    private final UserService userService;
    private final BookService bookService;

    public ProfileController(GenreService genreService, UserService userService, BookService bookService) {
        this.genreService = genreService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/{profile}")
    public ModelAndView getUser(@PathVariable String profile) {
        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("genres", genreService.findAll());
        modelAndView.addObject("user", userService.findUserByLogin(profile));
        return modelAndView;
    }

    @GetMapping("/{profile}/library")
    public ModelAndView getUserBooks(@PathVariable String profile,
                                     @RequestParam(value = "status", required = false) String status) {
        ModelAndView modelAndView = new ModelAndView("library.html");
        modelAndView.addObject("genres", genreService.findAll());
        if (status == null) {
            modelAndView.addObject("books", bookService.findByUser(profile));
        } else {
            modelAndView.addObject("books", bookService.findByUserAndStatus(profile, status));
        }
        return modelAndView;
    }
}