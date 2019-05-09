package com.github.nkolytschew.registration.service.remote.impl;

import com.github.nkolytschew.registration.service.jpa.entity.User;
import com.github.nkolytschew.registration.service.remote.MappingService;
import com.github.nkolytschew.registration.service.rest.model.MyUser;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MappingServiceImpl implements MappingService {

    /**
     * The Service Name of the instance
     */
    private final String mappingServiceId = "mapping-service";


    /**
     * send Request to another Micro-service;
     * This is the plain Spring way using an 'URI'
     * <p>
     * please compare with 'Feign' client in USER-SERVICE to see,
     * how you can use an interface to simplify the request
     */
    private final RestTemplate template;

    private final EurekaClient discoveryClient;


    public MappingServiceImpl(EurekaClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        this.template = new RestTemplate();
    }

    /**
     * send request to MappingService
     * and return mapped MyUser-API response to controller
     */
    @Override
    public ResponseEntity<MyUser> mapToApiResponse(User entity) {
        final var response = template.postForEntity(this.serviceUrl() + "/map/to/api", entity, MyUser.class);
        return response;
    }

    /**
     * send request to MappingService
     * and return mapped User-Entity response to controller
     */
    @Override
    public ResponseEntity<User> mapFromApiToEntity(MyUser user) {
        final var response = template.postForEntity(this.serviceUrl() + "/map/to/entity", user, User.class);
        return response;
    }

    /**
     * Helper method to get next available URL, if there is more than one instance running,
     * for the requested service
     */
    private String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(mappingServiceId, false);
        return instance.getHomePageUrl();
    }
}
