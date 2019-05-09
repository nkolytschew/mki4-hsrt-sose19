package com.github.nkolytschew.monolith.example.service;


import com.github.nkolytschew.monolith.example.domain.MyUser;
import com.github.nkolytschew.monolith.example.jpa.User;

public interface MappingService {

    MyUser mapFromEntity(User entity);

    User mapFromDomain(MyUser domain);
}
