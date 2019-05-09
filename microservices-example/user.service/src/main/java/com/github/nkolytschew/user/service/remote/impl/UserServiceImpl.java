package com.github.nkolytschew.user.service.remote.impl;

import com.github.nkolytschew.user.service.remote.UserService;
import com.github.nkolytschew.user.service.remote.rest.RegistrationClient;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final RegistrationClient registrationClient;

    public UserServiceImpl(RegistrationClient registrationClient) {
        this.registrationClient = registrationClient;
    }


    @Override
    public Resource getUsers() {
        return registrationClient.getUsers();
    }
}
