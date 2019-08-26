package com.interactivefun.crudframework.contracts;

import java.util.UUID;

public interface IRead<T> {

    T readOne(UUID identity);
    Iterable<T> readAll();

}
