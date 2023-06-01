package org.yup.deliapp;

public enum FreeTopping {
    LETTUCE(1),
    PEPPERS(2),
    ONIONS(3),
    TOMATOES(4),
    JALAPENOS(5),
    CUCUMBERS(6),
    PICKLES(7),
    GUACAMOLE(8),
    MUSHROOMS(9),
    MAYO(10),
    MUSTARD(11),
    KETCHUP(12),
    RANCH(13),
    THOUSAND_ISLAND(14),
    VINAIGRETTE(15),
    AU_JUS(16),
    SAUCE(17);

    private final int value;

    FreeTopping(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
