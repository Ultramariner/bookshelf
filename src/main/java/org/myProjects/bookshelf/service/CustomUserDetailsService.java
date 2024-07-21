package org.myProjects.bookshelf.service;

import org.myProjects.bookshelf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(userLogin);
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}
