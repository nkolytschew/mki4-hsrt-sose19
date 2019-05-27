package com.github.nkolytschew.mapping.service.rest;


import com.github.nkolytschew.mapping.service.domain.MyUser;
import com.github.nkolytschew.mapping.service.domain.User;
import com.github.nkolytschew.mapping.service.service.MappingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("map/to")
public class MappingController {

    private final MappingService service;

    @Value("${server.port}")
    private int serverPort;

    public MappingController(MappingService service) {
        this.service = service;
    }

    @PostMapping("api")
    public MyUser getMappedApiUser(@RequestBody User entity) throws UnknownHostException {
        final var response = this.service.mapFromEntityToApi(entity);
        response.setPort(serverPort);
        response.setInetAddress(InetAddress.getLocalHost().getHostAddress());
        return response;
    }

    @PostMapping("entity")
    public User getMappedEntityUser(@RequestBody MyUser apiUser) {
        final var response = this.service.mapFromApiToEntity(apiUser);
        return response;
    }
}
