package com.example.authentication;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/login"); // custom login endpoint
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Map<String, String> creds = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            String username = creds.get("username");
            String password = creds.get("password");

            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password);

            return authenticationManager.authenticate(token);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        String token = Jwts.builder()
            .setSubject(authResult.getName())
            .signWith(SignatureAlgorithm.HS256, "mySecretKey".getBytes()) // use stronger secret in real app
            .compact();
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
        // response.getWriter().write("Login Successful: " + authResult.getName());
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.getWriter().write("Login Failed: " + failed.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
