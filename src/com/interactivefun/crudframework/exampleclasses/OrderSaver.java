package com.interactivefun.crudframework.exampleclasses;

import com.interactivefun.crudframework.contracts.ISave;

import java.util.ArrayList;

public class OrderSaver implements ISave<Order> {
    private ArrayList<Order> database;

    public OrderSaver(ArrayList<Order> database){

        this.database = database;
    }

    @Override
    public void save(Order entity) {
        for(int index = 0; index < database.size(); index++)
        {
            Order item = database.get(index);
            if(item.getOrderNumber() == entity.getOrderNumber())
            {
                database.set(index, entity);
                return;
            }
        }

        database.add(entity);
    }
}
