package org.yup.deliapp;

public abstract class PremiumToppings {

    private boolean hasExtra;
    public abstract double getPrice();

    public PremiumToppings(boolean hasExtra) {
        this.hasExtra = hasExtra;
    }

    public boolean hasExtra() {
        return hasExtra;
    }
}
