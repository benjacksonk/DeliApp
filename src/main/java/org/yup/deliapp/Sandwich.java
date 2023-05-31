package org.yup.deliapp;

import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private SandwichSize size;
    private boolean isToasted;
    private BreadType breadType;
    private ArrayList<MeatType> meats;
    private ArrayList<CheeseType> cheeses;
    private ArrayList<FreeTopping> freeToppings;

    public Sandwich(SandwichSize size, boolean isToasted, BreadType breadType) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;

        meats = new ArrayList<MeatType>();
        cheeses = new ArrayList<CheeseType>();
        freeToppings = new ArrayList<FreeTopping>();
    }

    public void addMeat(MeatType meatType) {
        meats.add(meatType);
    }

    public void addCheese(CheeseType cheeseType) {
        cheeses.add(cheeseType);
    }

    public void addFreeTopping(FreeTopping topping) {
        freeToppings.add(topping);
    }

    public double getPrice() {
        double price;

        switch (size) {
            case FOUR_INCHES:
                price = 5.50;
                price += 1.00 * meats.size();
                price += 0.75 * cheeses.size();
                break;
            case EIGHT_INCHES:
                price = 7.00;
                price += 2.00 * meats.size();
                price += 1.50 * cheeses.size();
                break;
            case TWELVE_INCHES:
                price = 8.50;
                price += 3.00 * meats.size();
                price += 2.25 * cheeses.size();
                break;
            default:
                price = 0;
        }

        return price;
    }
}
