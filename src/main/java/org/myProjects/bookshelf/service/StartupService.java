package org.myProjects.bookshelf.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final UserService userService;
    private final BookService bookService;

    @PostConstruct
    public void init() {
        userService.findUserByLogin("user1");
        bookService.findByName("oo");
        bookService.findByGenre("genre1");
    }
}