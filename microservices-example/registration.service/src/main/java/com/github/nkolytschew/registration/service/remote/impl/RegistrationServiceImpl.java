package com.github.nkolytschew.registration.service.remote.impl;

import com.github.nkolytschew.registration.service.jpa.RegistrationRepository;
import com.github.nkolytschew.registration.service.remote.MappingService;
import com.github.nkolytschew.registration.service.remote.RegistrationService;
import com.github.nkolytschew.registration.service.rest.model.MyUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * repository to save MyUser to Database
     */
    private final RegistrationRepository repository;

    /**
     * call to mapping service to map to entity
     */
    private final MappingService mappingService;

    public RegistrationServiceImpl(RegistrationRepository repository, MappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    /**
     * Generate Overhead!!
     * <p>
     * map from Api to Entity.
     * save to Database.
     * map from Entity to Api.
     */
    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public ResponseEntity<MyUser> createUser(MyUser user) {
        final var userEntity = mappingService.mapFromApiToEntity(user);
        final var entity = repository.save(userEntity.getBody());
        final var response = mappingService.mapToApiResponse(entity);
        return response;
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public ArrayList<MyUser> getAllUser() {
        final var entities = repository.findAll();
        final var userList = new ArrayList<MyUser>();
        entities.forEach(user -> userList.add(mappingService.mapToApiResponse(user).getBody()));

        return userList;
    }

    private ResponseEntity<MyUser> reliable(MyUser user){
        final var myUser = new MyUser();
        myUser.setName("default-fallback");
        return ResponseEntity.ok(myUser);
    }

    private ArrayList<MyUser> reliable2(){
        return new ArrayList<>();
    }
}
