package org.yup.deliapp;

public class Chips extends OrderItem {
    private final double price = 1.50;


    public double getPrice() {
        return price;
    }


    public enum chipOptions {
        ORIGINAL_LAYS,
        FRITOS,
        BBQ_LAYS,
        DORITOS,
        BLUE_DORITOS,
        ORIGINAL_SUNCHIPS,
        CHEETOS,
        TOSTITOS
    }


}
