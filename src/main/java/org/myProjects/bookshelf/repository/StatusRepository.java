package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository  extends JpaRepository<Book, Integer> {
}
