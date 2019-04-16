package com.github.nkolytschew.springdata.jpa.repository;


import com.github.nkolytschew.springdata.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


// crud already provided! wohooo ... no select, insert, update, delete to write by ourselves!
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByForename(@Param("forename") String forename);

    User findUserBySurname(@Param("surname") String surname);

    User findUserByForenameAndSurname(@Param("forename") String forename, @Param("surname") String surname);

    User findUserByForenameOrSurname(@Param("forename") String forename, @Param("surname") String surname);



}
