package com.example.spring_security.services;

import com.example.spring_security.models.AuthenticationRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class PostAuthService {
    String adress;

    public PostAuthService(){
    }
}
