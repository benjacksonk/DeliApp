package org.yup.deliapp;

public class Chips {
    private final double price = 1.50;

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

    public double getPrice(chipOptions chip) {
        return price;
    }

}
