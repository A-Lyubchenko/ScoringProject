package com.scoring.scoring.registration.controllers;

import com.scoring.scoring.exception.NoSuchEntityException;
import com.scoring.scoring.registration.domain.EncodePassword;
import com.scoring.scoring.registration.domain.User;
import com.scoring.scoring.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EncodePassword encodePassword;

    @GetMapping("/users")
    public List<User> read() {

        return userService.read();
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") UUID uuid) {
        User user = userService.getEntityById(uuid);
        if (user == null) {
            throw new NoSuchEntityException("There is no user with id " + uuid + " in DataBase");
        }
        return userService.getEntityById(uuid);
    }


    @PostMapping("/users")
    public User create(@RequestBody User user) {
        user.setPassword(encodePassword.encodePassword(user.getPassword()));
        return userService.create(user);

    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return userService.update(user);


    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        User user = userService.getEntityById(uuid);

        if (user == null) {
            throw new NoSuchEntityException("There is no user with id " + uuid + " in DataBase");
        }

        userService.deleteEntity(userService.getEntityById(uuid));
        return "Person with id  = " + uuid + " was deleted";

    }

}
