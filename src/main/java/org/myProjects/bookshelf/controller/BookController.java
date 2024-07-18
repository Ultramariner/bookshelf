package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;

    public BookController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping("/{shortName}")
    public ModelAndView get(@PathVariable String shortName) {
        ModelAndView modelAndView = new ModelAndView("book.html");
        modelAndView.addObject("genres", genreService.findAll());
        //org.springframework.expression.spel.SpelEvaluationException: EL1007E: Property or field 'getName' cannot be found on null
        modelAndView.addObject("book", bookService.findByShortName(shortName));
        modelAndView.addObject("status", bookService.findMyStatusByBookId(bookService.findByShortName(shortName).getId()));
        return modelAndView;
    }

}