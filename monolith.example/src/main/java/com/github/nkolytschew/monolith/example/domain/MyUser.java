package com.github.nkolytschew.monolith.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // because of Jackson-Mapping
@Data
public class MyUser {

    private String username;

    private String name;

}
