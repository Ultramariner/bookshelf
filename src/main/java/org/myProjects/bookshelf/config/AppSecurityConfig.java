package org.myProjects.bookshelf.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
public class AppSecurityConfig {

    private final TokenGeneratorFilter generatorFilter;
    private final TokenValidationFilter validationFilter;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers("/main").permitAll()
//                .antMatchers("/search").permitAll()
//                .antMatchers("/book").permitAll()
//                .antMatchers("/reader").permitAll()
//                .antMatchers("/profile").authenticated()
//                .and()
//                .addFilterBefore(validationFilter, LogoutFilter.class)
//                .addFilterAfter(generatorFilter, UsernamePasswordAuthenticationFilter.class)
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/main").permitAll()
                        .requestMatchers("/search").permitAll()
                        .requestMatchers("/book").permitAll()
                        .requestMatchers("/reader").permitAll()
                        .requestMatchers("/profile").authenticated()
                )
                .addFilterBefore(validationFilter, LogoutFilter.class)
                .addFilterAfter(generatorFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(withDefaults());
        return http.build();
    }

}
