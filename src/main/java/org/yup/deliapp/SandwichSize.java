package org.yup.deliapp;

public enum SandwichSize {
    FOUR_INCHES(4),
    EIGHT_INCHES(8),
    TWELVE_INCHES(12);

    private final int value;

    SandwichSize(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
