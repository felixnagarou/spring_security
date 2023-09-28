package com.example.spring_security.services;

import com.example.spring_security.models.AuthenticationRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class PostAuthService {
    String adress;

    public PostAuthService(String adress){
        this.adress = adress;
    }
}
