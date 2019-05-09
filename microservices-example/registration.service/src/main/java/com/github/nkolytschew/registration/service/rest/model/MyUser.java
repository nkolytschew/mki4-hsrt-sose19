package com.github.nkolytschew.registration.service.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor // because of Jackson
@Data
public class MyUser {

    private String username;
    private String name;


    // additional API information about the user
    /**
     * check when this user was registered
     */
    private LocalDateTime registrationDate;
    /**
     * check if this user was "deleted" within the database
     */
    private Boolean active;

    private int port;
    private String inetAddress;
}
