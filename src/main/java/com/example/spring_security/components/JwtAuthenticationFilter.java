package com.example.spring_security.components;

import com.example.spring_security.entities.UserEntity;
import com.example.spring_security.services.CustomerUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenGenerator jwtTokenGenerator;
    private final CustomerUserDetailsService customerUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if (StringUtils.hasText(token)&& jwtTokenGenerator.validateToken(token)){
            String username = jwtTokenGenerator.getUserFromToken(token);

            UserEntity userFound = customerUserDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userFound.getEmail(),
                    userFound.getPassword(),
                    userFound.getAuthorities()
            );
            authenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        }
        filterChain.doFilter(request, response);

    }

    private String getJwtFromRequest(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader)&& authHeader.startsWith("Bearer") ){
            return authHeader.substring("Bearer".length());
        }

        return null;
    }
}
