package com.github.nkolytschew.petlegacysystemmock.mock.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {


    @RequestMapping("register")
    public String register() {
        System.err.println("request eingegangen!");
        return "ok";
    }

}
