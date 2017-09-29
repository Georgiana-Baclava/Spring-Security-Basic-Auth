package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PingController {

    @Autowired
    public PingController(){
        System.out.print("");
    }

    @GetMapping("/ping")
    @PreAuthorize("hasAuthority('BASIC_AUTH')")
    public String ping() {
        return "ping";
    }
}
