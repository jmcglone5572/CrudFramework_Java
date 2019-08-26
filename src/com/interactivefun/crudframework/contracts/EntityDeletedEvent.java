package com.interactivefun.crudframework.contracts;

public class EntityDeletedEvent<T> implements IEvent {

    private T deletedEntity;
    public T getDeletedEntity() { return deletedEntity; }
    public void setDeletedEntity(T entityToDelete) {deletedEntity = entityToDelete; }


    public EntityDeletedEvent(T entity)
    {
        setDeletedEntity(entity);
    }

    @Override
    public String getName() {

        return "EntityDeleted";
    }
}
