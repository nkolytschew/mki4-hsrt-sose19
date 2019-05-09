package com.github.nkolytschew.mapping.service.service.impl;

import com.github.nkolytschew.mapping.service.domain.MyUser;
import com.github.nkolytschew.mapping.service.domain.User;
import com.github.nkolytschew.mapping.service.service.MappingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MappingServiceImpl implements MappingService {

    @Override
    public User mapFromApiToEntity(MyUser user) {
        final var response = new User();
        response.setActive(true);
        response.setAddress("Default Address");
        response.setCreationDate(LocalDateTime.now());
        response.setName(user.getName());
        response.setUsername(user.getUsername());

        return response;
    }

    @Override
    public MyUser mapFromEntityToApi(User user) {
        final var response = new MyUser();
        response.setActive(user.isActive());
        response.setName(user.getName());
        response.setUsername(user.getUsername());
        response.setRegistrationDate(user.getCreationDate());

        return response;
    }
}
