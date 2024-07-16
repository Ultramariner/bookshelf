package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ModelAndView get(@RequestParam (value = "category", required = true) String category,
                            @RequestParam (value = "name", required = true) String name) {
        ModelAndView modelAndView = new ModelAndView("search.html");
        if (category == "genre") {
            modelAndView.addObject("books", bookService.findByGenre(name));
        } else {
            modelAndView.addObject("books", bookService.findByName(name));
        }
        return modelAndView;
    }
}
