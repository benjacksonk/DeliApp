package org.yup.deliapp;

import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private UUID orderNumber;
    private ArrayList<OrderItem> orderItems;

    public Order(UUID orderNumber, ArrayList<OrderItem> orderItems) {
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
    }

    public UUID getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        for (OrderItem orderItem : orderItems){
            totalCost += orderItem.getPrice();
        }

        return  totalCost;
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }
}
