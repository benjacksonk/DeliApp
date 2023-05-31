package org.yup.deliapp;

public class Meat extends PremiumToppings {

    @Override
    public double getPrice(int subSize) {
        double meatPrice;
        double extraMeatPrice;



        switch (subSize) {
            case 4:
                meatPrice = 1.00;
                extraMeatPrice = .50;
                break;
            case 8:
                meatPrice = 2.00;
                extraMeatPrice = 1.00;
                break;
            case 12:
                meatPrice = 3.00;
                extraMeatPrice = 1.50;
                break;
            default:
                // Handle invalid sub sizes or additional logic if needed
                return 0.0;
        }
        if (isHasExtra()) {
            return meatPrice + extraMeatPrice ;
        } else {
            return meatPrice;
        }
    }
}
