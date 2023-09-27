package com.example.spring_security.controllers;

import com.example.spring_security.models.Client;
import com.example.spring_security.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getHomePage(){
        return "home";
    }

    @PostMapping
    public String redirectAuth(String mode, Model model){
        model.addAttribute("mode", mode);
        return "redirect:/auth" + mode;
    }


}
