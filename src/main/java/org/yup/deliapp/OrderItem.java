package org.yup.deliapp;

public abstract class OrderItem {

    private static int nextItemNumber = 1;
    private int itemNumber;

    public abstract double getPrice();

    public abstract String stringFormat();

    public OrderItem(){
        this.itemNumber = nextItemNumber;
        nextItemNumber++;
    }

    public int getItemNumber() {
        return itemNumber;
    }
}
