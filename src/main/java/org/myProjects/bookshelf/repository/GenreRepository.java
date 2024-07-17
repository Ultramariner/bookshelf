package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
