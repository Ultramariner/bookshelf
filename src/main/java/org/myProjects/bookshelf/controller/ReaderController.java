package org.myProjects.bookshelf.controller;

import org.myProjects.bookshelf.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/reader")
public class ReaderController {

    private final TextService textService;

    public ReaderController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/{bookId}")
    public ModelAndView get(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("reader.html");
        modelAndView.addObject("bookText", textService.getText(bookId));
        return modelAndView;
    }

}
