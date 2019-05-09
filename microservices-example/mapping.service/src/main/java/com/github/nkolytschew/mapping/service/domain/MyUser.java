package com.github.nkolytschew.mapping.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // because of Jackson
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

    private Integer port;
    private String inetAddress;
}
