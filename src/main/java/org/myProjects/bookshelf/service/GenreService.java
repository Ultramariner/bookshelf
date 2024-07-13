package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.Genre;
import org.myProjects.bookshelf.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<Genre> getAll ()  {
        return repository.findAll();
    }

}
