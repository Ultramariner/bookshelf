package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.model.*;
import org.myProjects.bookshelf.service.BookService;
import org.myProjects.bookshelf.service.GenreService;
import org.myProjects.bookshelf.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;
    private final LibraryService libraryService;

    public BookController(BookService bookService, GenreService genreService, LibraryService libraryService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.libraryService = libraryService;
    }

    /*todo
     @GetMapping("/{shortName}")
     public ModelAndView get(@PathVariable String shortName) {
         return new ModelAndView("book.html")
                 .addObject("genres", genreService.findAll())
                 .addObject("book", bookService.findByShortName(shortName))
                 .addObject("status", bookService.findMyStatusByBookId(book.getId()));
     }*/
    @GetMapping("/{shortName}")
    public ModelAndView get(@PathVariable String shortName) {
        ModelAndView modelAndView = new ModelAndView("book.html");
        modelAndView.addObject("genres", genreService.findAll());
        //org.springframework.expression.spel.SpelEvaluationException: EL1007E: Property or field 'getName' cannot be found on null
        modelAndView.addObject("book", bookService.findByShortName(shortName));
        modelAndView.addObject("status", bookService.findMyStatusByBookId(bookService.findByShortName(shortName).getId()));
        return modelAndView;
    }


    @PostMapping("/{shortName}")
    public ModelAndView update(@PathVariable String shortName,
                               Integer status) {

       /* todo
        Book book = bookService.findByShortName(shortName);
        if (status != null) {
            libraryService.updateOrInsertBookStatus(new Library(new LibraryLink(new User(1), book), new Status(status)));
        } else {
            libraryService.deleteBookFromLibrary(new LibraryLink(new User(1), book));
        }
        return get(shortName);*/
        if (status != null) {
            libraryService.updateOrInsertBookStatus(new Library(new LibraryLink(new User(1), new Book(bookService.findByShortName(shortName).getId())), new Status(status)));
        } else {
            libraryService.deleteBookFromLibrary(new LibraryLink(new User(1), new Book(bookService.findByShortName(shortName).getId())));
        }
        return get(shortName);
    }

//    @PostMapping("/{shortName}")
//    public ModelAndView update(@PathVariable String shortName,
//                               @RequestParam(value = "status", required = false)) {
//
//        return null;
//    }

}