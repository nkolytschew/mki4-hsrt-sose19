package com.github.nkolytschew.mapping.service.service;


import com.github.nkolytschew.mapping.service.domain.MyUser;
import com.github.nkolytschew.mapping.service.domain.User;

public interface MappingService {

    User mapFromApiToEntity(MyUser user);

    MyUser mapFromEntityToApi(User user);
}
