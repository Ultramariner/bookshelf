package org.myProjects.bookshelf.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.myProjects.bookshelf.service.TokenProvider;
import org.myProjects.bookshelf.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TokenGeneratorFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userName = request.getParameter("userName");

        UserDetails userDetails = userService.getByUserName(userName);

        if (userDetails != null) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), "", userDetails.getAuthorities());

            String token = tokenProvider.createToken(auth);
            response.setHeader("mytoken", token);
        }

        filterChain.doFilter(request, response);
    }

}
