package com.example.contactsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin.html";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied.html";
    }
}