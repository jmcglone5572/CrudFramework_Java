package com.interactivefun.crudframework.exampleclasses;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Date;
import java.util.UUID;

public class Order extends Equals
{
    private UUID orderNumber;
    private String customerLastName;
    private String customerFirstName;
    private Date orderDate;

    public UUID getOrderNumber() {return orderNumber; }
    public void setOrderNumber(UUID orderNumber) {this.orderNumber = orderNumber; }

    public String getCustomerLastName() { return customerLastName; }
    public void setCustomerLastName(String customerLastName) { this.customerLastName = customerLastName; }

    public String getCustomerFirstName() { return customerFirstName; }
    public void setCustomerFirstName(String customerFirstName) { this.customerFirstName = customerFirstName; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }

        final Order other = (Order) obj;
        if(this.orderNumber == other.orderNumber)
        {
            return true;
        }

        return false;
    }

    @Override
    public final String toString()
    {
        String s = "OrderNumber:" + getOrderNumber() +
                ", Customer:" + getCustomerFirstName()
                + " " + getCustomerLastName() +
                ", OrderDate:" + getOrderDate();
        return s;
    }

}
