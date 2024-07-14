package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.Book;
import org.myProjects.bookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    public BookService (BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findByGenre(String genre) {
        return repository.findByGenreName(genre);
    }

    public List<Book> findByName(String name) {
        return repository.findByNameContains(name);
    }

    public List<Book> findAll() {return repository.findAll();}

    public List<Book> findTop5ByRating() { return repository.findTop5ByOrderByRatingDesc();}

    public List<Book> findTop5ByCreateDate() { return repository.findTop5ByOrderByCreateDateDesc();}

}
