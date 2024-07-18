package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "short_name", unique = true)
    private String shortName;
    private String name;
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
    private Long rating;
    private String description;
    private String author;

    public Book(Integer id) {
        this.id = id;
    }

    public String getGenresString() {
        return genres.toString().replace("[","").replace("]","");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", createDate=" + createDate +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
