package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.User;
import org.myProjects.bookshelf.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public  UserService (UserRepository repository) {
        this.repository = repository;
    }

    public User findUserByLogin (String login) {
        return repository.findByLogin(login);
    }

}
