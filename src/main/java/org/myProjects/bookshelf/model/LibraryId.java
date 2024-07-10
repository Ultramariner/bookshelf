package org.myProjects.bookshelf.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class LibraryId implements Serializable {

    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;

}