package org.yup.deliapp;

public class Meat extends PremiumToppings {
    private MeatType meatType;
    private SandwichSize size;

    public Meat(MeatType meatType, boolean hasExtra, SandwichSize size) {
        super(hasExtra);
        this.meatType = meatType;
        this.size = size;
    }

    @Override
    public double getPrice() {
        double regularPrice;
        double extraPrice;

        switch (size) {
            case FOUR_INCHES:
                regularPrice = 1.00;
                extraPrice = 0.50;
                break;
            case EIGHT_INCHES:
                regularPrice = 2.00;
                extraPrice = 1.00;
                break;
            case TWELVE_INCHES:
                regularPrice = 3.00;
                extraPrice = 1.50;
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

    public MeatType getMeatType() {
        return meatType;
    }
}
