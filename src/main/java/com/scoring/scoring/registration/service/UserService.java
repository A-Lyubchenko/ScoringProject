package com.scoring.scoring.registration.service;


import com.scoring.scoring.registration.domain.User;
import com.scoring.scoring.registration.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements Crud<User> {

    @Autowired
    private UserRepositories userRepositories;


    @Override
    public void create(User entity) {
        userRepositories.save(entity);
    }

    @Override
    public List<User> read() {
        return userRepositories.findAll();

    }

    @Override
    public void update(User entity) {
        userRepositories.save(entity);
    }

    @Override
    public void deleteEntity(User entity) {
        userRepositories.delete(entity);
    }

    @Override
    public User getEntityById(UUID id) {
        Optional<User> byId = userRepositories.findById(id);
        return byId.orElseGet(byId::get);
    }


    public boolean isUniqueEmail(User user) {
        User entity = userRepositories.findUserByEmail(user.getEmail());

        if (entity == null) {
            return true;
        }

        UUID userId = user.getId();
        UUID entityId = entity.getId();

        return userId.equals(entityId);
    }

    public boolean isUniqueUserName(User user) {
        User entity = userRepositories.findUserByUsername(user.getUsername());

        if (entity == null) {
            return true;
        }

        UUID userId = user.getId();
        UUID entityId = entity.getId();

        return userId.equals(entityId);
    }

}

