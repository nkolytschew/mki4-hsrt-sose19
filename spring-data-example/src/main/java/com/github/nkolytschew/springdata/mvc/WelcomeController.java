package com.github.nkolytschew.springdata.mvc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value(("${application.custom.welcome.message}"))
    private String welcomeMesage;

    @GetMapping("/")
    public String printWelcomeMessage() {
        return welcomeMesage;
    }
}
