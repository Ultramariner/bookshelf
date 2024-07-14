package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.Book;
import org.myProjects.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findByGenre(String genre) {
        return repository.findByGenreName(genre);
    }

    public List<Book> findByName(String name) {
        return repository.findByNameContains(name);
    }

    public List<Book> findAll() {return repository.findAll();}

}
