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

    public Sandwich(SandwichSize size, boolean isToasted, BreadType breadType, ArrayList<Meat> meats,
                    ArrayList<Cheese> cheeses, ArrayList<FreeTopping> freeToppings) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.meats = meats;
        this.cheeses = cheeses;
        this.freeToppings = freeToppings;
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

    @Override
    public String stringFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("CUSTOM SANDWICH: ")
                .append("\n")
                .append(size)
                .append(isToasted ? " toasted" : "")
                .append(" ")
                .append(breadType)
                .append("\n");

        builder.append("MEAT: ");
        for (Meat meat : meats) {
            builder.append(meat.getMeatType()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nCHEESE: ");
        for (Cheese cheese : cheeses) {
            builder.append(cheese.getCheeseType()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nFREE TOPPINGS: ");
        for (FreeTopping topping : freeToppings) {
            builder.append(topping).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nSANDWICH TOTAL: $").append(String.format("%.2f", getPrice()));

        return builder.toString();
    }

}
