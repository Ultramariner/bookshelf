package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.GenreService;
import org.myProjects.bookshelf.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final GenreService genreService;
    private final StatusService statusService;

    public BookController(GenreService genreService, StatusService statusService) {
        this.genreService = genreService;
        this.statusService = statusService;
    }

    @GetMapping()
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("book.html");
        modelAndView.addObject("genres", genreService.findAll());
        modelAndView.addObject("statuses", statusService.findAll());
        return modelAndView;
    }

}