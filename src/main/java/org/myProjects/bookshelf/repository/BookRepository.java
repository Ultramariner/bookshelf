package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b RIGHT JOIN FETCH b.genres g WHERE b.id in (SELECT b.id FROM Book b LEFT JOIN b.genres g WHERE g.id = :genreId) ORDER BY g.id")
    List<Book> findByGenreId(@Param("genreId") Integer genreId);

    List<Book> findByNameContains(String name);

    Book findByShortName(String shortName);

    @Query("SELECT b.source FROM Book b WHERE b.id = :bookId")
    String findSourceById(@Param("bookId") Integer id);

    //использовать findByOrderByRatingDesc и брать первые 5?
    List<Book> findTop5ByOrderByRatingDesc();

    List<Book> findTop5ByOrderByCreateDateDesc();

    List<Book> findByOrderByRatingDesc();

    List<Book> findByOrderByCreateDateDesc();

    @Query("SELECT b FROM Book b JOIN FETCH Library l ON b.id = l.libraryLink.book.id JOIN FETCH User u ON l.libraryLink.user.id = u.id WHERE u.name = :userName")
    List<Book> findByUser(@Param("userName") String userName);

    //использовать findByUser?
    @Query("SELECT b FROM Book b JOIN FETCH Library l ON b.id = l.libraryLink.book.id JOIN FETCH User u ON l.libraryLink.user.id = u.id WHERE u.name = :userName AND l.status.id = :status")
    List<Book> findByUserAndStatus(@Param("userName") String userName, @Param("status") Integer status);

}
