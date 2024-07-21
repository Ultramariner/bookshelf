package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

    private final BookService bookService;
    private final GenreService genreService;

    public SearchController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    /* todo
     @GetMapping()
     public ModelAndView get(@RequestParam(value = "category") String category,
                             @RequestParam(value = "value", required = false) String value) {
         return new ModelAndView("search.html")
                 .addObject("genres", genreService.findAll())
                 .addObject("books", switch (category) {
                     case "genre" -> bookService.findByGenreId(Integer.parseInt(value));
                     case "best" -> bookService.findAllByRating();
                     case "new" -> bookService.findAllByCreateDate();
                     case "name" -> bookService.findByName(value);
                     default -> throw new IllegalArgumentException("Invalid category: " + category);
                 });
     }*/
    @GetMapping()
    public ModelAndView get(@RequestParam(value = "category") String category,
                            @RequestParam(value = "value", required = false) String value) {
        ModelAndView modelAndView = new ModelAndView("search.html");
        modelAndView.addObject("genres", genreService.findAll());
        if (Objects.equals(category, "genre")) {
            modelAndView.addObject("books", bookService.findByGenreId(Integer.parseInt(value)));
        } else if (Objects.equals(category, "best")) {
            modelAndView.addObject("books", bookService.findAllByRating());
        } else if (Objects.equals(category, "new")) {
            modelAndView.addObject("books", bookService.findAllByCreateDate());
        } else if (Objects.equals(category, "name")) {
            modelAndView.addObject("books", bookService.findByName(value));
        }
        return modelAndView;
    }
}
