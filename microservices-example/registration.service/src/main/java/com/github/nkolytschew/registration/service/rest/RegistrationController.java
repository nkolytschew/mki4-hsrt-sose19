package com.github.nkolytschew.registration.service.rest;

import com.github.nkolytschew.registration.service.remote.MappingService;
import com.github.nkolytschew.registration.service.remote.RegistrationService;
import com.github.nkolytschew.registration.service.rest.model.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RegistrationController {


    // remote to create User in Database
    private final RegistrationService registrationService;

    // remote to map from User-Entity to API-Object
    private final MappingService mappingService;

    public RegistrationController(RegistrationService registrationService, MappingService mappingService) {
        this.registrationService = registrationService;
        this.mappingService = mappingService;
    }

    // request:
    // GET        with request parameters
    //   localhost:8080?userName=Nik&name=Nikita.Kolytschew
    //
    // POST/PUT   with request body
    //   localhost:8080
    // valid body:    { "username": "nik", "name": "nikita"}
    // invalid body:  { "username": "nik", "name1": "nikita"}
    //
    @PostMapping("user")
    public ResponseEntity<MyUser> createMyUser(@RequestBody MyUser user) {
        final var response = this.registrationService.createUser(user);

        return response;
    }

    @GetMapping("users")
    public ArrayList<MyUser> users() {
        return this.registrationService.getAllUser();
    }

}
