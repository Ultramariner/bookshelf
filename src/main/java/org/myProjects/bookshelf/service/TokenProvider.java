package org.myProjects.bookshelf.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

@Component
public class TokenProvider {

    @Value("${spring.security.token.key}")
    private String secret;
    private SecretKey secretKey;
    public static final String AUTH_KEY = "auth";

    @PostConstruct
    public void init() {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Authentication authentication) {
        String userName = authentication.getPrincipal().toString();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return Jwts.builder()
                .setSubject(userName)
                .claim(AUTH_KEY, authorities)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
        String auth = claims.get(AUTH_KEY).toString();
        String userName = claims.getSubject();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, null, List.of(() -> auth));
        return authToken;
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJwt(token);
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

}
