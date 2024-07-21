package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.model.User;
import org.myProjects.bookshelf.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public  UserService (UserRepository repository) {
        this.repository = repository;
    }

    public User findByName (String name) {
        return repository.findByName(name);
    }

    public UserDetails getByUserName (String username) {
        if (username != null && username.equals("user1")) {
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(username)
                    .password("password")
                    .authorities("read")
                    .build();
            return userDetails;
        } else {
            return null;
        }
    }

}
