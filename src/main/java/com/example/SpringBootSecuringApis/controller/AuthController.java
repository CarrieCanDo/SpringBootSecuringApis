package com.example.SpringBootSecuringApis.controller;

import com.example.SpringBootSecuringApis.dto.LoginRequestDTO;
import com.example.SpringBootSecuringApis.security.JwtTokenUtil;
import jakarta.validation.Valid;
import org.owasp.encoder.Encode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    // Constructor Injection
    public AuthController(JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        // Sanitize inputs
        String sanitizedUsername = Encode.forHtml(loginRequest.getUsername());
        String sanitizedPassword = Encode.forHtml(loginRequest.getPassword());

        try {
            // Authenticate using sanitized inputs
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(sanitizedUsername, sanitizedPassword)
            );
            return jwtTokenUtil.generateToken(sanitizedUsername);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
