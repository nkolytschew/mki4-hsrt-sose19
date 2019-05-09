package com.github.nkolytschew.monolith.example.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "rest/user")
public interface UserRepository extends CrudRepository<User, Long> {
}
