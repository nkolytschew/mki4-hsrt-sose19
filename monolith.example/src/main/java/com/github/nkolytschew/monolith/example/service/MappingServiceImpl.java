package com.github.nkolytschew.monolith.example.service;

import com.github.nkolytschew.monolith.example.domain.MyUser;
import com.github.nkolytschew.monolith.example.jpa.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MappingServiceImpl implements MappingService {


    @Override
    public MyUser mapFromEntity(User entity) {
        System.out.println(String.format("User=%s with ID=%s", entity, entity.getId()));
        final var myUser = new MyUser();

        myUser.setName(entity.getName());
        myUser.setUsername(entity.getUsername());

        return myUser;
    }

    @Override
    public User mapFromDomain(MyUser domain) {
        System.out.println(String.format("Domain=%s", domain));

        final var user = new User();

        user.setUsername(domain.getUsername());
        user.setName(domain.getName());

        // set creationDate to now
        user.setCreationDate(LocalDateTime.now());

        return user;
    }
}
