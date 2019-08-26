package com.interactivefun.crudframework.exampleclasses;

import com.interactivefun.crudframework.contracts.IDelete;
import com.interactivefun.crudframework.contracts.IRead;
import com.interactivefun.crudframework.contracts.ISave;

import java.util.UUID;

public class OrderController {
    private final IRead<Order> reader;
    private final ISave<Order> saver;
    private final IDelete<Order> deleter;

    public OrderController(IRead<Order> reader, ISave<Order> saver, IDelete<Order> deleter){

        this.reader = reader;
        this.saver = saver;
        this.deleter = deleter;
    }

    public void createOrder(Order order)
    {
        saver.save(order);
    }

    public Order getSingleOrder(UUID identity)
    {
        return reader.readOne(identity);
    }

    public Iterable<Order> getAllOrders() {

        return reader.readAll();
    }

    public void updateOrder(Order order)
    {
        saver.save(order);
    }

    public void deleteOrder(Order order)
    {
        deleter.delete(order);
    }
}
