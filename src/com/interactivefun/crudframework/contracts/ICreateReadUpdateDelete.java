package com.interactivefun.crudframework.contracts;

import java.util.UUID;

public interface ICreateReadUpdateDelete<T> {
    void create(T entity);

    T readOne(UUID identity);

    Iterable<T> readAll();

    void update(T entity);

    void delete(T entity);
}
