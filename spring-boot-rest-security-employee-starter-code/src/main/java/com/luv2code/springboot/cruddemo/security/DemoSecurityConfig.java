package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    // add support for JDBC ... no more hard coded users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // inject the data source
        // Auto configure by Spring boot

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?");

        return jdbcUserDetailsManager;
        // Tells spring security to use JDBC authentication with our data source
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE") // Read single employee
                                .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")// creating new employee
                                .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic();

        // disable Cross site Request forgery(CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf().disable();

        return http.build();
    }
/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        /*UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")// noop means no operation for plain text
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")// noop means no operation for plain text
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")// noop means no operation for plain text
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }
*/
}
