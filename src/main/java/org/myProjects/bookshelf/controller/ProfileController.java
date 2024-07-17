package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.myProjects.bookshelf.service.StatusService;
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
    private final StatusService statusService;

    public ProfileController(GenreService genreService, UserService userService, BookService bookService, StatusService statusService) {
        this.genreService = genreService;
        this.userService = userService;
        this.bookService = bookService;
        this.statusService = statusService;
    }

    @GetMapping("/{name}")
    public ModelAndView getUser(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("genres", genreService.findAll());
        modelAndView.addObject("user", userService.findByName(name));
        return modelAndView;
    }

    @GetMapping("/{name}/library")
    public ModelAndView getUserBooks(@PathVariable String name,
                                     @RequestParam(value = "status", required = false) Integer status) {
        ModelAndView modelAndView = new ModelAndView("library.html");
        modelAndView.addObject("genres", genreService.findAll());
        modelAndView.addObject("statuses", statusService.findAll());
        if (status == null) {
            modelAndView.addObject("books", bookService.findByUser(name));
        } else {
            modelAndView.addObject("books", bookService.findByUserAndStatus(name, status));
        }
        return modelAndView;
    }
}