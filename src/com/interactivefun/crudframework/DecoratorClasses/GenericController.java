package com.interactivefun.crudframework.DecoratorClasses;

import com.interactivefun.crudframework.contracts.ICreateReadUpdateDelete;
import com.interactivefun.crudframework.contracts.IDelete;
import com.interactivefun.crudframework.contracts.IRead;
import com.interactivefun.crudframework.contracts.ISave;

import java.util.UUID;

public class GenericController<T> implements ICreateReadUpdateDelete<T> {

    private final IRead<T> reader;
    private final ISave<T> saver;
    private final IDelete<T> deleter;

    public GenericController(IRead<T> reader, ISave<T> saver, IDelete<T> deleter)
    {
        this.reader = reader;
        this.saver = saver;
        this.deleter = deleter;
    }

    @Override
    public void create(T entity) {
        saver.save(entity);
    }

    @Override
    public T readOne(UUID identity) {
        return reader.readOne(identity);
    }

    @Override
    public Iterable<T> readAll() {
        return reader.readAll();
    }

    @Override
    public void update(T entity) {
        saver.save(entity);
    }

    @Override
    public void delete(T entity) {
        deleter.delete(entity);
    }
}
