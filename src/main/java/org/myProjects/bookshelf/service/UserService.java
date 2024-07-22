package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.myProjects.bookshelf.model.User;
import org.myProjects.bookshelf.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService {

    private final UserRepository repository;

    public  UserService (UserRepository repository) {
        this.repository = repository;
    }

    public User findByName (String name) {
        return repository.findByName(name);
    }

    //todo User\UserDetails
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

    public User findUserByLogin(String userLogin) {
        Optional<User> userOptional = repository.getUserByLogin(userLogin);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        } else {
            throw new RuntimeException("Пользователь не найден");
        }
    }
}
