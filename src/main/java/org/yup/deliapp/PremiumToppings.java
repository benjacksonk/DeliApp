package org.yup.deliapp;

public abstract class PremiumToppings {

    private boolean hasExtra;
        public abstract double getPrice(int subSize);

    public boolean isHasExtra() {
        return hasExtra;
    }
}
