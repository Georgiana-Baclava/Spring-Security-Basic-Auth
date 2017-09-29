package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by student on 29.09.2017.
 */
@Controller
public class Mappings {

    @GetMapping("/")
    public String app() {
        return "app";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('BASIC_AUTH')")
    public String home() {
        System.out.println("ELA");
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
