package org.yup.deliapp;

public class Cheese extends PremiumToppings {
    private CheeseType cheeseType;
    private SandwichSize size;

    public Cheese(CheeseType cheeseType, boolean hasExtra, SandwichSize size) {
        super(hasExtra);
        this.cheeseType = cheeseType;
        this.size = size;
    }

    @Override
    public double getPrice() {
        double regularPrice;
        double extraPrice;

        switch (size) {
            case FOUR_INCHES:
                regularPrice = 0.75;
                extraPrice = 0.30;
                break;
            case EIGHT_INCHES:
                regularPrice = 1.50;
                extraPrice = 0.60;
                break;
            case TWELVE_INCHES:
                regularPrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                // Handle invalid sub sizes or additional logic if needed
                regularPrice = 0;
                extraPrice = 0;
                break;
        }

        if (hasExtra()) {
            return regularPrice + extraPrice;
        }
        else {
            return regularPrice;
        }
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }
}
