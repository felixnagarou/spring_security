package com.example.spring_security.controllers;

import com.example.spring_security.models.AuthenticationRequest;
import com.example.spring_security.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("mode", "register");
        model.addAttribute("formValues", AuthenticationRequest.builder().build());

        return "auth/registerForm";
    }

    @GetMapping("/authenticate")
    public String getAuthenticationForm(Model model){
        model.addAttribute("mode", "authenticate");
        model.addAttribute("formValues", AuthenticationRequest.builder().build());

        return "auth/registerForm";
    }

    @PostMapping("/register")
    public String registerHandler(AuthenticationRequest formValues, HttpServletRequest request){
        authService.register(formValues);
         SecurityContext context = SecurityContextHolder.getContext();
        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", context);
        return "redirect:/private";
    }

    @PostMapping("/authenticate")
    public String authenticateHandler(AuthenticationRequest formValues, HttpServletRequest request) {
        authService.authenticate(formValues);
        System.out.println(request.getRequestURI());

        SecurityContext context = SecurityContextHolder.getContext();
        HttpSession session = request.getSession();



        session.setAttribute("SPRING_SECURITY_CONTEXT", context);

        return "redirect:/private/space";
    }

    @PostMapping("/disconnect")
    public String disconnectHandler(HttpServletRequest request){
        HttpSession session = request.getSession();

        SecurityContext context = SecurityContextHolder.getContext();
        session.setAttribute("SPRING_SECURITY_CONTEXT", context);
        return "redirect:/auth";
    }
}
