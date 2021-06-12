package com.github.grizzly.repository;

import java.util.List;

public interface JPARepository<T> {
    T save(T entity);

    List<T> findAll();

    T findBy(T entity);

    void update(T entity);

    void remove(T entity);
}
