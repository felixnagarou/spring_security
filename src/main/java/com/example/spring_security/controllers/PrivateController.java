package com.example.spring_security.controllers;

import com.example.spring_security.models.Client;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String getPrivateHomePage(HttpServletRequest request){
        return "private/privateSpace";
    }



}
