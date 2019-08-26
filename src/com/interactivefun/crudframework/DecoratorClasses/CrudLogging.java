package com.interactivefun.crudframework.DecoratorClasses;

import com.interactivefun.crudframework.contracts.ICreateReadUpdateDelete;
import com.interactivefun.crudframework.contracts.ILog;

import java.util.UUID;

public class CrudLogging<T> implements ICreateReadUpdateDelete<T> {

    private final Class<T> typeparameterclass;

    private ICreateReadUpdateDelete<T> decoratedCrud;
    private ILog log;

    public CrudLogging(Class<T> typeParameterClass, ICreateReadUpdateDelete<T> decratedCrud, ILog log)
    {
        this.typeparameterclass = typeParameterClass;
        this.decoratedCrud = decratedCrud;
        this.log = log;
    }


    @Override
    public void create(T entity) {
        log.logMessage("Creating entity of type " + typeparameterclass.getName());
        decoratedCrud.create(entity);
    }

    @Override
    public T readOne(UUID identity) {

        log.logMessage("Reading entity f type " + typeparameterclass.getName() + " with identity " + identity);
        return decoratedCrud.readOne(identity);
    }

    @Override
    public Iterable<T> readAll() {
        log.logMessage("Reading all entities of type " + typeparameterclass.getName());

        return decoratedCrud.readAll();
    }

    @Override
    public void update(T entity) {
        log.logMessage("Updating entity of type " + typeparameterclass.getName());

        decoratedCrud.update(entity);
    }

    @Override
    public void delete(T entity) {
        log.logMessage("Deleting entity of type " + typeparameterclass.getName());

        decoratedCrud.delete(entity);

    }
}

