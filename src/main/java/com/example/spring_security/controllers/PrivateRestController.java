package com.example.spring_security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/private")
public class PrivateRestController {

    public String helloPrivate(){
        return "hi private ;)";
    }
}
