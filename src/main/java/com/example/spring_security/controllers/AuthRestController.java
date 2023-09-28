package com.example.spring_security.controllers;

import com.example.spring_security.models.AuthenticationRepsonse;
import com.example.spring_security.models.AuthenticationRequest;
import com.example.spring_security.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthRestController {
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationRepsonse> registerHandler(@RequestBody AuthenticationRequest formValues) {
        String token = authService.register(formValues);

        AuthenticationRepsonse response = AuthenticationRepsonse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }



    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationRepsonse> authenticateHandler(@RequestBody AuthenticationRequest formValues) {
        String token = authService.authenticate(formValues);

        AuthenticationRepsonse response = AuthenticationRepsonse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }
}
