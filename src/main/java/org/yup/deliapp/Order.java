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
}
