package com.github.nkolytschew.monolith.example.mvc.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "hello";
    }


}
