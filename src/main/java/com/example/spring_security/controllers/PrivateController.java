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
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        if (client != null){
        return "private/home";
        }
        return "redirect:";
    }


    @GetMapping("/private")
    public String getPrivateFavoritesPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        if (client != null){
            return "private/favorites";
        }
        return "redirect:";

    }

    @GetMapping("/private")
    public String getPrivateUtilsPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        if (client != null){
            return "private/utils";
        }
        return "redirect:";

    }



}
