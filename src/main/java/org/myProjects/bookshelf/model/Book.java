package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String short_name;
    private String name;
    @ManyToMany
    private List<Genre> genres;
    private String source;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date create_date;

}