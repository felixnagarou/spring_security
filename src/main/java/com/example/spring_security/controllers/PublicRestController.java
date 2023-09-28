package com.example.spring_security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/public")
public class PublicRestController {
    public String getHelloPublic(){
        return "Hi public ENDPOINT :) :) :) ";
    }
}
