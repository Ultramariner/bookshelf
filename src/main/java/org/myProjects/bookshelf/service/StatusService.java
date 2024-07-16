package org.myProjects.bookshelf.service;

import org.myProjects.bookshelf.model.Book;
import org.myProjects.bookshelf.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {return repository.findAll();}

}
