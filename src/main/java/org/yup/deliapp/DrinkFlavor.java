package org.yup.deliapp;

enum DrinkFlavor {

    SPRITE(1),
    PEPSI(2),
    COKE(3),
    WATER(4),
    LEMONADE(5),
    ICED_TEA(6),
    DIET_COKE(7),
    ORANGE_FANTA(8),
    BLUE_POWERADE(9),
    DR_PEPPER(10);

    private final int value;

    DrinkFlavor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
