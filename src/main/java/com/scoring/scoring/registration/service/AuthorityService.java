package com.scoring.scoring.registration.service;


import com.scoring.scoring.registration.domain.Authority;
import com.scoring.scoring.registration.repositories.AuthorityRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorityService implements Crud<Authority>{


    @Autowired
    private AuthorityRepositories authorityRepositories;

    @Override
    public void create(Authority entity) {

    }

    @Override
    public List<Authority> read() {
        return authorityRepositories.findAll();
    }

    @Override
    public void update(Authority entity) {

    }

    @Override
    public void deleteEntity(Authority entity) {

    }

    @Override
    public Authority getEntityById(UUID id) {
        Optional<Authority> byId = authorityRepositories.findById(id);
        return byId.orElseGet(byId::get);
    }
}
