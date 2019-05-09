package com.github.nkolytschew.user.service.remote.rest;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("registration-service")
public interface RegistrationClient {

    @GetMapping("users")
    Resource getUsers();
}
