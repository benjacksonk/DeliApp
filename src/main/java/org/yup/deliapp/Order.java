package org.yup.deliapp;

import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private String orderNumber;
    private ArrayList<OrderItem> orderItems;

    public Order(String orderNumber, ArrayList<OrderItem> orderItems) {
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
    }

    public String getOrderNumber() {
        UUID generatedOrderID = UUID.randomUUID();
        String printedOrderID = generatedOrderID.toString().substring(0, 5);
        return printedOrderID;
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
