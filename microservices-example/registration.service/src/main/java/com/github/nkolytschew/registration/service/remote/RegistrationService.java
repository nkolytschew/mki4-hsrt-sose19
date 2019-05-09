package com.github.nkolytschew.registration.service.remote;


import com.github.nkolytschew.registration.service.rest.model.MyUser;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface RegistrationService {
    ResponseEntity<MyUser> createUser(MyUser user);

    ArrayList<MyUser> getAllUser();
}
