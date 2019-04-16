package com.github.nkolytschew.springdata.jpa.repository;

import com.github.nkolytschew.springdata.jpa.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findAddressesByUserForeignKey(@Param("userForeignKey") Long userForeignKey);
}
