package org.myProjects.bookshelf.repository;

import org.myProjects.bookshelf.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository  extends JpaRepository<Status, Integer> {
}
