package com.interactivefun.crudframework.DecoratorClasses;

import com.interactivefun.crudframework.contracts.IRead;

import java.util.UUID;

public class ReadCaching<T> implements IRead<T> {

    private  Iterable<T> allCachedEntities = null;
    private final IRead<T> decorated;

    public ReadCaching(IRead<T> decorated)
    {
        this.decorated = decorated;
    }

    @Override
    public T readOne(UUID identity) {
        return decorated.readOne(identity);
    }

    @Override
    public Iterable<T> readAll() {
        if(allCachedEntities == null)
        {
            allCachedEntities = decorated.readAll();
        }

        return allCachedEntities;
    }
}
