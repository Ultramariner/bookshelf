package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.Book;
import org.myProjects.bookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findByGenreId(Integer genreId) {
        return repository.findByGenreId(genreId);
    }

    public List<Book> findByName(String name) {
        return repository.findByNameContains(name);
    }

    public Book findByShortName(String shortName) {
        return repository.findByShortName(shortName);
    }

    public List<Book> findByUser(String user) {
        return repository.findByUser(user);
    }

    public List<Book> findByUserAndStatus(String user, Integer status) {
        return repository.findByUserAndStatus(user, status);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public String findSourceById(Integer id) {
        return repository.findSourceById(id);
    }

    public Integer findMyStatusByBookId(Integer id) {
        return repository.findMyStatusIdByBookId(id);
    }

    public List<Book> findAllByRating() {
        return repository.findByOrderByRatingDesc();
    }

    public List<Book> findAllByCreateDate() {
        return repository.findByOrderByCreateDateDesc();
    }

    public List<Book> findTop5ByRating() {
        return repository.findTop5ByOrderByRatingDesc();
    }

    public List<Book> findTop5ByCreateDate() {
        return repository.findTop5ByOrderByCreateDateDesc();
    }

}
