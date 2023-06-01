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
        ORIGINAL_LAYS(1),
        FRITOS(2),
        BBQ_LAYS(3),
        DORITOS(4),
        BLUE_DORITOS(5),
        ORIGINAL_SUNCHIPS(6),
        CHEETOS(7),
        TOSTITOS(8);

        private final int value;

        chipOptions(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }



    public chipOptions getChipFlavor() {
        return chipFlavor;
    }
}
