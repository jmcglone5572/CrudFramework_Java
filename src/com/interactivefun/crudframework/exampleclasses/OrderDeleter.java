package com.interactivefun.crudframework.exampleclasses;

import com.interactivefun.crudframework.contracts.IDelete;

import java.util.ArrayList;

public class OrderDeleter implements IDelete<Order> {

    private ArrayList<Order> database;

    public OrderDeleter(ArrayList<Order> database)
    {
        this.database = database;
    }

    @Override
    public void delete(Order entity)
    {
        database.remove(entity);
    }
}
