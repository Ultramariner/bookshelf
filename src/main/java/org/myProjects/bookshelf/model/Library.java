package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libraries")
public class Library {

    @EmbeddedId
    private LibraryLink libraryLink;
    private int status;

}
