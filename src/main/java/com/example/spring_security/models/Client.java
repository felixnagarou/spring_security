package com.example.spring_security.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private String identifiant;
    private String password;
}
