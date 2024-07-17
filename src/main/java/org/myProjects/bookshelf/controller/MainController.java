package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/main")
public class MainController {

    private final BookService bookService;
    private final GenreService genreService;

    public MainController (BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("main.html");
        modelAndView.addObject("topBooks", bookService.findTop5ByRating());
        modelAndView.addObject("newBooks", bookService.findTop5ByCreateDate());
        modelAndView.addObject("genres", genreService.findAll());
        return modelAndView;
    }

}