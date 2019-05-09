package com.github.nkolytschew.registration.service.jpa;

import com.github.nkolytschew.registration.service.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<User, Long> {
}
