package org.myProjects.bookshelf.service;

import lombok.Getter;
import lombok.Setter;
import org.myProjects.bookshelf.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private User userEntity;
    @Setter
    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails fromUserToCustomUserDetails(User user) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.username = user.getName();
        customUserDetails.password = user.getPassword();
        customUserDetails.userEntity = user;
        return customUserDetails;
    }

}
