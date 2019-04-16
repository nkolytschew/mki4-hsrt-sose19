package com.github.nkolytschew.springdata.mvc;

import com.github.nkolytschew.springdata.jpa.entity.User;
import com.github.nkolytschew.springdata.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id)
                .get();
    }

    @GetMapping("users")
    public Iterable<User> getAllUser() {
        return repository.findAll();
    }

    // for test only... please :-*
    @GetMapping("create/user")
    public User createRandomUser() {
        final var newUser = new User(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return repository.save(newUser);
    }

    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        repository.deleteById(id);
    }


    @GetMapping("user/{name}")
    public User getUserByName(@PathVariable String name) {
        return repository.findUserByForename(name);
    }

}
