package org.yup.deliapp;

public enum MeatType {
    STEAK(1),
    HAM(2),
    SALAMI(3),
    ROAST_BEEF(4),
    CHICKEN(5),
    BACON(6);

    private final int value;

    MeatType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
