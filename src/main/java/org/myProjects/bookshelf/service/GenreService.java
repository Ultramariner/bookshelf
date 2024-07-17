package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.Genre;
import org.myProjects.bookshelf.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GenreService {

    private final GenreRepository repository;

    public GenreService (GenreRepository repository) {
        this.repository = repository;
    }

    public List<Genre> findAll ()  {
        return repository.findAll();
    }

}
