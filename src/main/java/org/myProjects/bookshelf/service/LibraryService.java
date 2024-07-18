package org.myProjects.bookshelf.service;

import org.myProjects.bookshelf.model.Library;
import org.myProjects.bookshelf.model.LibraryLink;
import org.myProjects.bookshelf.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void updateOrInsertBookStatus(Library library) {
        repository.updateOrInsert(library);
    }

    public void deleteBookFromLibrary(LibraryLink libraryLink){repository.deleteById(libraryLink);}
}
