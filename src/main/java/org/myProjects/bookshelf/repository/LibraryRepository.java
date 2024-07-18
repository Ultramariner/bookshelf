package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Library;
import org.myProjects.bookshelf.model.LibraryLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, LibraryLink> {

    default Library updateOrInsert(Library library) {
        return save(library);
    }



}
