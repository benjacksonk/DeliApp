package org.yup.deliapp;

public class Chips extends OrderItem {
    private final double price = 1.50;
    private chipOptions chipFlavor;

    public Chips(chipOptions chipFlavor) {
        this.chipFlavor = chipFlavor;
    }

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

    public chipOptions getChipFlavor() {
        return chipFlavor;
    }
}
