package com.example.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.core.userdetails.User;

// @Configuration
// @EnableWebSecurity
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
    //     CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authManager);
    //     http.csrf().disable()
    //         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //         .and()
    //         .addFilterAt(new CustomAuthenticationFilter(authManager), UsernamePasswordAuthenticationFilter.class)
    //         .addFilterAfter(new JwtAuthorizationFilter(), CustomAuthenticationFilter.class)
    //         .authorizeRequests()
    //         .requestMatchers("/api/login").permitAll()
    //         .anyRequest().authenticated();
    //     return http.build();
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return new InMemoryUserDetailsManager(
    //             User.withUsername("veer").password(passwordEncoder().encode("veer123")).roles("USER").build(),
    //             User.withUsername("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN").build()
    //     );
    // }

    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    //     return http.getSharedObject(AuthenticationManagerBuilder.class)
    //                .userDetailsService(userDetailsService())
    //                .passwordEncoder(passwordEncoder())
    //                .and()
    //                .build();
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
    
}
