package com.scoring.scoring.registration.service;

import java.util.List;
import java.util.UUID;

public interface Crud<T> {


    T create(T entity);

    List<T> read();

    T update(T entity);

    void deleteEntity(T entity);

    T getEntityById(UUID id);

}
