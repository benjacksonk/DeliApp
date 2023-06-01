package org.yup.deliapp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Screens {

    static Scanner userScanner = new Scanner(System.in); //static scanner - will be able to use it throughout the class
//    static ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
    static Order currentOrder;

    public static String homeScreen(){
        //the main screen or main menu
        System.out.println("Please choose from the following OPTIONS: ");
        System.out.println("\tO * NEW ORDER");
        System.out.println("\tX * EXIT");
        System.out.print("Please enter your selection: ");
        return userScanner.nextLine();

    }

    public static String orderScreen(){
        //where users can do basically everything with their order: add, view, cancel, pay
        System.out.println("Please choose from the following OPTIONS: ");
        System.out.println("\tS * Add SANDWICH");
        System.out.println("\tC * Add CHIPS");
        System.out.println("\tD * Add DRINKS");
        System.out.println("\tV * To VIEW Order");
        System.out.println("\tX * CANCEL Order");
        System.out.println("\tH * Back to HOME screen");
        System.out.print("Please ENTER your selection: ");
        String orderScreenChoice = userScanner.nextLine();


        switch (orderScreenChoice.toLowerCase()){
            case "s":
                sandwichOrder();
                break;

            case "c":
                chipOrder();
                break;

            case "d":
                drinkOrder();
                break;

            case "v":
                viewOrder();
                break;

            case "x":
                cancelOrder();
                break;

            default:
                System.out.println("Please enter a VIABLE option.");
                orderScreen();
                break;
        }

        return "";
    }

    public static void cancelOrder(){
        currentOrder = null;
        System.out.println("Your order has been successfully CANCELED");
        homeScreen();

    }

    public static void drinkOrder(){
        System.out.println("Please choose from the following FLAVORS: ");

        for (DrinkFlavor drinkFlavor : DrinkFlavor.values()) {
            System.out.println("\t"+drinkFlavor);
        }

        System.out.print("Please ENTER your selection: ");
        String flavorInput = userScanner.nextLine().toUpperCase();

        try {
            DrinkFlavor selectedFlavor = DrinkFlavor.valueOf(flavorInput);

            System.out.println("Please select SIZE (SMALL, MEDIUM, LARGE): ");
            String selectedSize = userScanner.nextLine().toUpperCase();

            if (selectedSize.equals("SMALL") || selectedSize.equals("MEDIUM") || selectedSize.equals("LARGE")) {
                Drinks drinkChoice = new Drinks(selectedSize, selectedFlavor);
                currentOrder.getOrderItems().add(drinkChoice);


            } else {
                System.out.println("Invalid size choice. Please try again.");
                drinkOrder();
            }

        }catch(IllegalArgumentException e){
            System.out.println("Invalid flavor choice. Please try again.");
            drinkOrder();
        }

    }

    public static void chipOrder(){
        System.out.println("Please choose from the following: ");
        for (Chips.chipOptions chipFlavors : Chips.chipOptions.values()) {
            System.out.println("\t" + chipFlavors);
        }

        System.out.println("Please ENTER your selection: ");
        String chipFlavor = userScanner.nextLine().toUpperCase();

        try {

            Chips.chipOptions selectedChip = Chips.chipOptions.valueOf(chipFlavor);
            Chips chipOrder = new Chips(selectedChip);
            currentOrder.getOrderItems().add(chipOrder);


        }catch(IllegalArgumentException e){
            System.out.println("Invalid chip choice. Please try again");
            chipOrder();
        }

    }

    public static void sandwichOrder() {
        System.out.println("Please enter the SIZE of your sandwich: ");
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            System.out.println(sandwichSize.getValue() + " = " + sandwichSize);
        }

        SandwichSize selectedSize = SandwichSize.valueOf(userScanner.nextLine().toUpperCase());

        System.out.println("Please choose the type of BREAD: ");
        for (BreadType breadType : BreadType.values()) {
            System.out.println(breadType);
        }

        BreadType selectedBread = BreadType.valueOf(userScanner.nextLine().toUpperCase());

        System.out.println("Did you want your bread TOASTED? (Y/N)");
        String toastedInput = userScanner.nextLine();
        boolean isToasted = toastedInput.equalsIgnoreCase("y");

        System.out.println("Please choose which MEAT: ");
        for (MeatType meatType : MeatType.values()) {
            System.out.println(meatType);
        }

        String meatInput = userScanner.nextLine();
        ArrayList<MeatType> selectedMeats = new ArrayList<>();
        if (!meatInput.isEmpty()) {
            String[] meatTypes = meatInput.split(",");
            for (String meat : meatTypes) {
                try {
                    MeatType selectedMeat = MeatType.valueOf(meat.trim().toUpperCase());
                    selectedMeats.add(selectedMeat);
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid meat type: " + meat);
                }
            }
        }

        System.out.println("Please choose which CHEESE: (separated by commas(,)) ");
        for (CheeseType cheeseType : CheeseType.values()) {
            System.out.println(cheeseType);
        }
        String cheeseInput = userScanner.nextLine();
        ArrayList<CheeseType> selectedCheeseTypes = new ArrayList<>();
        if (!cheeseInput.isEmpty()) {
            String[] cheeseTypes = cheeseInput.split(",");
            for (String cheese : cheeseTypes){
                try {
                    CheeseType selectedCheeseType = CheeseType.valueOf(cheese.trim().toUpperCase());
                    selectedCheeseTypes.add(selectedCheeseType);
                }catch (IllegalArgumentException e) {
                    System.out.println("Invalid cheese type: " + cheese);
                }
            }
        }

        System.out.println("Please choose which FREE TOPPING (please separate by commas(,)) or press ENTER to skip: ");
        for (FreeTopping freeTopping : FreeTopping.values()) {
            System.out.println(freeTopping);
        }

        String toppingsInput = userScanner.nextLine();
        ArrayList<FreeTopping> selectedToppings = new ArrayList<>();
        if (toppingsInput.isEmpty()) {
            String[] toppingTypes = toppingsInput.split(",");
                for (String topping : toppingTypes) {
                    try{
                        FreeTopping selectedTopping = FreeTopping.valueOf(topping.trim().toUpperCase());
                        selectedToppings.add(selectedTopping);
                    }catch (IllegalArgumentException e) {
                        System.out.println("Invalid topping: " + topping);
                    }
                }
            }

            Sandwich customSandwich = new Sandwich(selectedSize, isToasted, selectedBread);

        for (MeatType meatType : selectedMeats) {
            customSandwich.addMeat(meatType, false);
        }

        for (CheeseType cheeseType : selectedCheeseTypes) {
            customSandwich.addCheese(cheeseType, false);
        }

        for (FreeTopping topping : selectedToppings){
            customSandwich.addFreeTopping(topping);
        }

        if (currentOrder != null) {
            currentOrder.getOrderItems().add(customSandwich);
            System.out.println("Custom sandwich added to your order.");
        } else {
            System.out.println("ERROR");
        }
    }

    public static void viewOrder(){
        if (currentOrder == null || currentOrder.getOrderItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        }else{
            System.out.println("Your order contains the following items: ");

            for (OrderItem orderItems : currentOrder.getOrderItems()) {
                System.out.println(orderItems.toString());
            }
        }
        OrderManager.readOrder();
        System.out.println("Please choose from the following options: ");
        System.out.println("P * to CHECKOUT and PAY");
        System.out.println("A * to ADD to your order");
        System.out.println("R * to REMOVE item from your order");
        System.out.println("X * to CANCEL your order");
        String viewOrderChoice = userScanner.nextLine();

        switch (viewOrderChoice.toLowerCase()){
            case "p":
                OrderManager.readOrder();
                System.out.println("Please enter cash AMOUNT: ");
                double userAmount = userScanner.nextDouble();

                double totalCost = currentOrder.calculateTotalCost();

                if (userAmount >= totalCost) {
                    System.out.println("Payment successful. Your order has been placed");

                    OrderManager.writeOrder(currentOrder);

                    currentOrder = null;
                } else {
                    System.out.println("Insufficient payment amount. Please try again.");
                }
                break;

            case "a":
                orderScreen();
                break;

            case "r":
                System.out.println("Enter the index of the item to remove: ");
                //I have to figure out how to make it so that the user does not input the index of the AL
//                String itemIndex = userScanner.nextLine();
//                userScanner.nextLine();
//                currentOrder.removeItem();
                break;

            case "x":
                System.out.println("Are you sure you want to cancel your order? (Y?N)");
                String cancelConfirmation = userScanner.nextLine();

                if (cancelConfirmation.equalsIgnoreCase("y")) {
                    System.out.println("Order canceled.Your cart has been cleared.");
                    currentOrder = null;
                    homeScreen();
                }else{
                    System.out.println("Order cancellation aborted.");
                }
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

    }

}
