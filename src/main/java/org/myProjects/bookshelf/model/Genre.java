package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Book> books;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
