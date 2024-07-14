package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final GenreService genreService;

    public BookController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping()
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("book.html");
        modelAndView.addObject("genres", genreService.findAll());
        return modelAndView;
    }

}