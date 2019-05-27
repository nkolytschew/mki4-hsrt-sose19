package com.github.nkolytschew.petlegacysystemmock.mock.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Value("${application.api.version}")
    private String version;

    @RequestMapping("register")
    public String register() {
        System.err.println("request eingegangen!");
        return version;
    }

}
