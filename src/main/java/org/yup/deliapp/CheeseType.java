package org.yup.deliapp;

public enum CheeseType {
    AMERICAN(1),
    PROVOLONE(2),
    CHEDDAR(3),
    SWISS(4);

    private final int value;

    CheeseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
