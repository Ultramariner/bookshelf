package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.genres g WHERE g.name = :genreName")
    List<Book> findByGenreName(@Param("genreName") String genreName);

    List<Book> findByNameContains(String name);

    List<Book> findTop5ByOrderByRatingDesc();

    List<Book> findTop5ByOrderByCreateDateDesc();

    @Query("SELECT b FROM Book b LEFT JOIN FETCH Library l ON b.id = l.libraryLink.book.id LEFT JOIN FETCH User u ON l.libraryLink.user.id = u.id WHERE u.login = :userName")
    List<Book> findByUser(@Param("userName") String userName);

    @Query("SELECT b FROM Book b LEFT JOIN FETCH Library l ON b.id = l.libraryLink.book.id LEFT JOIN FETCH User u ON l.libraryLink.user.id = u.id WHERE u.login = :userName AND l.status.name = :status")
    List<Book> findByUserAndStatus(@Param("userName") String userName, @Param("status") String status);
}
