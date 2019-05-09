package com.github.nkolytschew.monolith.example.service;


import com.github.nkolytschew.monolith.example.domain.MyUser;

import java.util.List;

public interface UserService {

    MyUser createUser(MyUser user);

    List<MyUser> getUsers();
}
