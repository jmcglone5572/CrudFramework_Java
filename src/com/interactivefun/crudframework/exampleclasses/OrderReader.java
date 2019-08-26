package com.interactivefun.crudframework.exampleclasses;

import com.interactivefun.crudframework.contracts.IRead;

import java.util.ArrayList;
import java.util.UUID;

public class OrderReader implements IRead<Order> {

    private ArrayList<Order> database;
    public OrderReader(ArrayList<Order> database)
    {
        this.database = database;
    }

    @Override
    public Order readOne(UUID identity) {

        for(Order item : database)
        {
            if(item.getOrderNumber() == identity)
            {
                return item;
            }
        }

        return null;
    }

    @Override
    public Iterable<Order> readAll() {
        return database;
    }
}
