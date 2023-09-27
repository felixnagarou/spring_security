package com.example.spring_security.controllers;

import com.example.spring_security.models.Client;
import com.example.spring_security.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/public")
public class PublicController {

    private final ClientService clientService;

    @GetMapping
    public String getHomePage(@ModelAttribute("client") Client client, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("client", clientService.getClientData());
        return "home";
    }


}
