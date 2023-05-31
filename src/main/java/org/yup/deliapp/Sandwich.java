package org.yup.deliapp;

import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private SandwichSize size;
    private boolean isToasted;
    private BreadType breadType;
    private ArrayList<Meat> meats;
    private ArrayList<Cheese> cheeses;
    private ArrayList<FreeTopping> freeToppings;

    public Sandwich(SandwichSize size, boolean isToasted, BreadType breadType) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;

        meats = new ArrayList<Meat>();
        cheeses = new ArrayList<Cheese>();
        freeToppings = new ArrayList<FreeTopping>();
    }

    public void addMeat(MeatType meatType, boolean extra) {
        Meat meat = new Meat(meatType, extra, size);
        meats.add(meat);
    }

    public void addCheese(CheeseType cheeseType, boolean extra) {
        Cheese cheese = new Cheese(cheeseType, extra, size);
        cheeses.add(cheese);
    }

    public void addFreeTopping(FreeTopping topping) {
        freeToppings.add(topping);
    }

    public double getPrice() {
        double basePrice;

        switch (size) {
            case FOUR_INCHES:
                basePrice = 5.50;
                break;
            case EIGHT_INCHES:
                basePrice = 7.00;
                break;
            case TWELVE_INCHES:
                basePrice = 8.50;
                break;
            default:
                basePrice = 0;
        }

        double meatsSubtotal = meats.stream().mapToDouble(Meat::getPrice).sum();
        double cheesesSubtotal = cheeses.stream().mapToDouble(Cheese::getPrice).sum();

        return basePrice + meatsSubtotal + cheesesSubtotal;
    }

    public SandwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public ArrayList<Meat> getMeats() {
        return meats;
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public ArrayList<FreeTopping> getFreeToppings() {
        return freeToppings;
    }
}
