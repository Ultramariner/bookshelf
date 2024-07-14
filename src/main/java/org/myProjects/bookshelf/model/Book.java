package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "short_name", unique = true)
    private String shortName;
    private String name;
    //Refactor EAGER -> @Transactional (lazyInitializationException)
    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(name = "books_genres",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "genres_id")})
    private List<Genre> genres;
    private String source;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createDate;

}
