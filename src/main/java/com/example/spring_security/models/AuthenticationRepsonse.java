package com.example.spring_security.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRepsonse {
    private  String token;
    private String type="JWT";
}
