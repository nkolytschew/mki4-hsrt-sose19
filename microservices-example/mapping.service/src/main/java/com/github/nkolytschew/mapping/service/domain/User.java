package com.github.nkolytschew.mapping.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // because of Jackson
public class User {

    private Long id;

    private String name;
    private String username;

    private String address;

    private LocalDateTime creationDate;
    private boolean active = true;

    // additional properties
}
