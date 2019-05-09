package com.github.nkolytschew.monolith.example.service;

import com.github.nkolytschew.monolith.example.domain.MyUser;
import com.github.nkolytschew.monolith.example.jpa.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final String legacySystemUrl = "http://localhost:9999/register";
//    private final String legacySystemUrl = "https://api.chucknorris.io/jokes/random";

    private final MappingService mappingService;

    private final UserRepository userRepository;


    public RegistrationServiceImpl(MappingService mappingService, UserRepository userRepository) {
        this.mappingService = mappingService;
        this.userRepository = userRepository;
    }

    /**
     * 1. Schritt: benutzer bei uns in der DB anlegen!
     * 2. Schritt: benutzer an Legacy system weiter geben!
     * <p>
     * 3. Schritt: be cool :)
     *
     * @param user
     */
    @Override
    public void registerUser(MyUser user) {
        System.out.println("todo");


        final var entity = mappingService.mapFromDomain(user);
        userRepository.save(entity);

        // send to remote/legacy system

        final var restTemplate = new RestTemplate();
        restTemplate.getForObject(legacySystemUrl, String.class);

        // maybe more to come
    }
}
