package com.scoring.scoring.scoring.services;

import java.util.List;
import java.util.UUID;

public interface Crud<T> {

    T save(T entity);

    List<T> getAll();

    T update(T entity);

    void delete(T entity);

    T getById(UUID id);

}
