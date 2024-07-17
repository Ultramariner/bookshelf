package org.myProjects.bookshelf.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class LibraryLink implements Serializable {

    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;

}