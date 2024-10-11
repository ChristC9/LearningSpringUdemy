package com.chriscode.employeeproject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
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

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define sql queries to retrieve user information by user_id
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id = ?"
        );

        // define sql queries to retrieve user roles by user_id
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id = ?"
        );

        return jdbcUserDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails chris = User.builder()
//                .username("chris")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails linda = User.builder()
//                .username("linda")
//                .password("{noop}test123")
//                .roles("MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("ADMIN","EMPLOYEE","MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(chris, linda, susan);
//    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
                    configurer
                            .requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST, "api/employees").hasAnyRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT,"api/employees/**").hasAnyRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")
                );
        // use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable csrf
        http.csrf(csrf->csrf.disable());

        return http.build();
    };
}
