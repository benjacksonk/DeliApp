package org.yup.deliapp;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
//    private ArrayList<Sandwich> sandwiches;
//    private ArrayList<Chips> chips;
//    private ArrayList<Drinks> drinks;
    private ArrayList<OrderItem> orderItems;

    public Order(int orderNumber, ArrayList<OrderItem> orderItems) {
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
