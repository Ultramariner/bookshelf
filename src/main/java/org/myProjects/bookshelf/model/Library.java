package org.myProjects.bookshelf.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "libraries")
public class Library {

    @EmbeddedId
    private LibraryLink libraryLink;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Override
    public String toString() {
        return "Library{" +
                "libraryLink=" + libraryLink +
                '}';
    }
}
