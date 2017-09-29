package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by student on 29.09.2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_SPECIFIC_FOR_ENDPOINT = "BASIC_AUTH";

    @Value("${basic.auth.username}")
    private String username;

    @Value("${basic.auth.password}")
    private String password;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .antMatcher("/ping")
                .authorizeRequests()
                .anyRequest()
                .hasAuthority(ROLE_SPECIFIC_FOR_ENDPOINT)
                .and()
                .httpBasic()
        ;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(username)
                .password(password)
                .authorities(ROLE_SPECIFIC_FOR_ENDPOINT);
    }
}
