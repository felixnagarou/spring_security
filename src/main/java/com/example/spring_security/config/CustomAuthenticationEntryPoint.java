package com.example.spring_security.config;

import com.example.spring_security.services.PostAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        PostAuthService postAuthService = new PostAuthService().
        response.sendRedirect(request.getContextPath() + "/auth/authenticate");


       // response.setContentType(request.getRequestURI());

        //System.out.println(request.getRequestURI());

    }
}
