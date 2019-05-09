package com.github.nkolytschew.monolith.example.mvc.rest;


import com.github.nkolytschew.monolith.example.domain.MyUser;
import com.github.nkolytschew.monolith.example.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // request:
    // localhost:8080?userName=Nik&name=Nikita.Kolytschew
    // POST/PUT :
    // { "username": "nik", "name": "nikita"}
    //  { "username": "nik", "name1": "nikita"}
    //
    @PostMapping("user")
    public MyUser createMyUser(@RequestBody MyUser user) {
        return this.userService.createUser(user);
    }

}
