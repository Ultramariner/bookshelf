package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByGenres_Name(String name);

    List<Book> findByNameContains(String name);

}
