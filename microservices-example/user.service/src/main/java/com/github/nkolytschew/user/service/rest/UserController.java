package com.github.nkolytschew.user.service.rest;


import com.github.nkolytschew.user.service.remote.UserService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("users")
    public Resource getUsers() {
        return this.service.getUsers();
    }
}
