
package com.interactivefun.crudframework;

import com.interactivefun.crudframework.DecoratorClasses.*;
import com.interactivefun.crudframework.contracts.ICreateReadUpdateDelete;
import com.interactivefun.crudframework.exampleclasses.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Main {

    private static final ArrayList<Order> database = new ArrayList<Order>();


    public static void main(String[] args) {
	System.out.println("----- CRUD Framework Using Dependency Injection -----");


        Order order1 = new Order();
        order1.setOrderNumber(new UUID(0, 1));
        order1.setCustomerFirstName("Jim");
        order1.setCustomerLastName("McGlone");
        order1.setOrderDate(new Date());

        Order order2 = new Order();
        order2.setOrderNumber(new UUID(0, 2));
        order2.setCustomerFirstName("Linda");
        order2.setCustomerLastName("Farrar");
        order2.setOrderDate(new Date());

        Order order3 = new Order();
        order3.setOrderNumber(new UUID(0, 3));
        order3.setCustomerFirstName("Joe");
        order3.setCustomerLastName("Dokes");
        order3.setOrderDate(new Date());

        Order order4 = new Order();
        order4.setOrderNumber(new UUID(0, 4));
        order4.setCustomerFirstName("Fran");
        order4.setCustomerLastName("Tarkenton");
        order4.setOrderDate(new Date());

        Order order5 = new Order();
        order5.setOrderNumber(new UUID(0, 5));
        order5.setCustomerFirstName("Edward");
        order5.setCustomerLastName("Van Halen");
        order5.setOrderDate(new Date());

        ICreateReadUpdateDelete<Order> orderController = CreateOrderController();

        orderController.create(order1);
        orderController.create(order2);
        orderController.create(order3);
        orderController.create(order4);
        orderController.create(order5);

        orderController.delete(order2);

        Order anOrder = orderController.readOne(new UUID(0, 5));
        Iterable<Order> allOrders = orderController.readAll();

        order3.setCustomerFirstName("Henry");
        order3.setCustomerLastName("Benry");
        orderController.update(order3);



    }



    private static ICreateReadUpdateDelete<Order> CreateOrderController()
    {
        OrderReader reader = new OrderReader(database);
        ReadCaching<Order> readCachngReader = new ReadCaching<Order>(reader);

        OrderSaver saver = new OrderSaver(database);
        AuditInfoSaver auditInfoSaver = new AuditInfoSaver();
        SaveAuditing auditingSaver = new SaveAuditing<Order>(saver, auditInfoSaver);

        OrderDeleter deleter = new OrderDeleter(database);

        GenericController<Order> orderController = new GenericController<Order>(readCachngReader, auditingSaver, deleter);

        Logger logger = new Logger();

        Order dummyOrder = new Order();
        CrudLogging<Order> orderControllerWithLogging = new CrudLogging<Order>((Class<Order>) dummyOrder.getClass(), orderController, logger);

        return orderControllerWithLogging;
    }
}
