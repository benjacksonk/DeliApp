package org.yup.deliapp;

import java.text.DecimalFormat;
import java.util.*;

public class Screens {

    static Scanner userScanner = new Scanner(System.in); //static scanner - will be able to use it throughout the class
    static ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
    static UUID orderNumber = UUID.randomUUID();
    static String formattedOrderNumber = orderNumber.toString().substring(0, 5);
    static Order currentOrder = new Order(formattedOrderNumber, orderList);

    public static String homeScreen(){
        //the main screen or main menu
        System.out.println("Please choose from the following OPTIONS: ");
        System.out.println("\tO * NEW ORDER");
        System.out.println("\tX * EXIT");
        System.out.print("Please enter your selection: ");
        return userScanner.nextLine();

    }

    public static String orderScreen() {
        //where users can do basically everything with their order: add, view, cancel, pay

//        boolean isOrdering = true;
//
//        while (isOrdering) {
            System.out.println("Please choose from the following OPTIONS: ");
            System.out.println("\tS * Add SANDWICH");
            System.out.println("\tC * Add CHIPS");
            System.out.println("\tD * Add DRINKS");
            System.out.println("\tV * To VIEW Order");
            System.out.println("\tX * CANCEL Order");
            System.out.println("\tH * Back to HOME screen");
            System.out.print("Please ENTER your selection: ");
            String orderScreenChoice = userScanner.nextLine();


            switch (orderScreenChoice.toLowerCase()) {
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

//        }

//            orderScreen();
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
            System.out.println("\t"+drinkFlavor.getValue() + " * " + drinkFlavor);
        }

        System.out.print("Please enter your NUMBER selection: ");

        int flavorInput = userScanner.nextInt();
        userScanner.nextLine();

        try {
            DrinkFlavor selectedFlavor = null;
            for (DrinkFlavor drinkFlavor : DrinkFlavor.values()){
                if (drinkFlavor.getValue() == flavorInput) {
                    selectedFlavor = drinkFlavor;
                    break;
                }
            }

            if (selectedFlavor != null) {

                System.out.print("Please select SIZE (SMALL, MEDIUM, LARGE): ");
                String selectedSize = userScanner.nextLine().toUpperCase();

                if (selectedSize.equals("SMALL") || selectedSize.equals("MEDIUM") || selectedSize.equals("LARGE")) {
                    Drinks drinkChoice = new Drinks(selectedSize, selectedFlavor);
                    currentOrder.getOrderItems().add(drinkChoice);
                    System.out.printf("%s %s: $%.2f successfully added to your order.\n" + "\n",
                            drinkChoice.getSize(), drinkChoice.getFlavor(), drinkChoice.getPrice());

                    orderScreen();

                }else{
                    System.out.println("Invalid size choice. Please try again.");
                    drinkOrder();
                }

            } else {
                System.out.println("Invalid choice choice. Please try again.");
                drinkOrder();
            }

        }catch(IllegalArgumentException e){
            System.out.println("Invalid choice. Please try again.");
            drinkOrder();
        }

    }

    public static void chipOrder(){
        System.out.println("Please choose from the following: ");
        for (Chips.chipOptions chipFlavors : Chips.chipOptions.values()) {
            System.out.println("\t" + chipFlavors.getValue() + " * " + chipFlavors);
        }

        System.out.print("Please ENTER your NUMBER selection: ");
        int chipInput = userScanner.nextInt();
        userScanner.nextLine();

        try {

            Chips.chipOptions selectedChip = null;

            for(Chips.chipOptions chipFlavor : Chips.chipOptions.values()){
                if (chipFlavor.getValue() == chipInput) {
                    selectedChip = chipFlavor;
                    break;
                }
            }

            if (selectedChip != null) {
                Chips chipOrder = new Chips(selectedChip);
                currentOrder.getOrderItems().add(chipOrder);
                System.out.printf("%s: $%.2f successfully added to your order.\n" + "\n",
                        chipOrder.getChipFlavor(), chipOrder.getPrice());

                orderScreen();

            }else {
                System.out.println("Invalid chip choice. Please try again");
                chipOrder();
            }

        }catch(IllegalArgumentException e){
            System.out.println("Invalid chip choice. Please try again");
            chipOrder();
        }

    }

    public static void sandwichOrder() {

        System.out.println("Please enter the NUMBER of the SIZE of your sandwich: ");
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            System.out.println("\t" + sandwichSize.getValue() + " * " + sandwichSize);
        }

        int userSizeInput = userScanner.nextInt();
        userScanner.nextLine();

        SandwichSize selectedSize = null;

        for (SandwichSize sandwichSize : SandwichSize.values()) {
            if (sandwichSize.getValue() == userSizeInput) {
                selectedSize = sandwichSize;
                break;

            }
        }

        if (selectedSize == null) {
            System.out.println("Invalid Input.");
        }

        System.out.println("Please enter the NUMBER of the type of BREAD: ");
        for (BreadType breadType : BreadType.values()) {
            System.out.println("\t" + breadType.getValue() + " * " + breadType);
        }

        int userBreadInput = userScanner.nextInt();
        userScanner.nextLine();

        BreadType selectedBread = null;

        for (BreadType breadType : BreadType.values()) {
            if (breadType.getValue() == userBreadInput) {
                selectedBread = breadType;
                break;

            }
        }
        if (selectedBread == null) {
            System.out.println("Invalid Input.");
        }

        System.out.println("Did you want your bread TOASTED? (Y/N)");
        String toastedInput = userScanner.nextLine();
        boolean isToasted = toastedInput.equalsIgnoreCase("y");

        System.out.println("Please enter the NUMBER of the MEAT/s you want added: ");
        for (MeatType meatType : MeatType.values()) {
            System.out.println("\t" + meatType.getValue() + " * " + meatType);
        }

        String meatInput = userScanner.nextLine();
        String[] meatNumbers = meatInput.split(" ");
        ArrayList<MeatType> selectedMeats = new ArrayList<>();

        for (String meatNumber : meatNumbers) {
            int number = Integer.parseInt(meatNumber.trim());

            boolean isValidMeat = false;
            for (MeatType meatType : MeatType.values()) {
                if (meatType.getValue() == number) {
                    selectedMeats.add(meatType);
                    isValidMeat = true;
                    break;
                }
            }

            if (!isValidMeat) {
                System.out.println("Invalid Input: " + number);
            }
        }

        System.out.println("Do you want to add extra meat? (Y/N)");
        String addExtraMeatInput = userScanner.nextLine();
        boolean addExtraMeat = addExtraMeatInput.equalsIgnoreCase("y");

        System.out.println("Please enter the NUMBER of the CHEESE/s you want added: ");
        for (CheeseType cheeseType : CheeseType.values()) {
            System.out.println("\t" + cheeseType.getValue() + " * " + cheeseType);
        }
        String cheeseInput = userScanner.nextLine();
        String[] cheeseNumbers = cheeseInput.split(" ");
        ArrayList<CheeseType> selectedCheeseTypes = new ArrayList<>();

        for (String cheeseNumber : cheeseNumbers) {
            int number = Integer.parseInt(cheeseNumber.trim());

            boolean isValidCheese = false;
            for (CheeseType cheeseType : CheeseType.values()) {
                if (cheeseType.getValue() == number) {
                    selectedCheeseTypes.add(cheeseType);
                    isValidCheese = true;
                    break;
                }
            }
            if (!isValidCheese) {
                System.out.println("Invalid Input: " + number);
            }
        }

        System.out.println("Do you want extra cheese? (Y/N)");
        String extraCheeseInput = userScanner.nextLine();
        boolean addExtraCheese = extraCheeseInput.equalsIgnoreCase("y");

        System.out.println("Please enter the NUMBER of the FREE TOPPING/s you want added or press ENTER to skip: ");
        for (FreeTopping freeTopping : FreeTopping.values()) {
            System.out.println("\t" + freeTopping.getValue() + " * " + freeTopping);
        }

        String toppingsInput = userScanner.nextLine();
        String[] toppingsNumbers = toppingsInput.split(" ");
        ArrayList<FreeTopping> selectedToppings = new ArrayList<>();

        for (String toppingNumber : toppingsNumbers) {
            int number = Integer.parseInt(toppingNumber.trim());

            boolean isValidTopping = false;
            for (FreeTopping freeTopping : FreeTopping.values()) {
                if (freeTopping.getValue() == number) {
                    selectedToppings.add(freeTopping);
                    isValidTopping = true;
                    break;
                }
            }
        }

        if (toppingsInput.isEmpty()) {
            String[] toppingTypes = toppingsInput.split(",");
            for (String topping : toppingTypes) {
                try {
                    FreeTopping selectedTopping = FreeTopping.valueOf(topping.trim().toUpperCase());
                    selectedToppings.add(selectedTopping);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid topping: " + topping);
                }
            }
        }

        Sandwich customSandwich = new Sandwich(selectedSize, isToasted, selectedBread);

        for (MeatType meatType : selectedMeats) {
            customSandwich.addMeat(meatType, addExtraMeat);
        }

        for (CheeseType cheeseType : selectedCheeseTypes) {
            customSandwich.addCheese(cheeseType, addExtraCheese);
        }

        for (FreeTopping topping : selectedToppings) {
            customSandwich.addFreeTopping(topping);
        }

        if (currentOrder != null) {
                    currentOrder.getOrderItems().add(customSandwich);
                    System.out.println(customSandwich.stringFormat());
                } else {
            System.out.println("ERROR");
        }

        orderScreen();

    }

    public static void viewOrder () {
        if (currentOrder == null || currentOrder.getOrderItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your order contains the following items: ");

            for (OrderItem orderItems : currentOrder.getOrderItems()) {
                System.out.println(orderItems.getItemNumber() + ". " + orderItems.stringFormat() + "\n");
            }

            System.out.println("\t" + "TOTAL: $" + currentOrder.calculateTotalCost() + "\n");
        }

        System.out.println("Please choose from the following options: ");
        System.out.println("P * to CHECKOUT and PAY");
        System.out.println("A * to ADD to your order");
        System.out.println("R * to REMOVE item from your order");
        System.out.println("X * to CANCEL your order");
        String viewOrderChoice = userScanner.nextLine();

        switch (viewOrderChoice.toLowerCase()) {
            case "p":
                System.out.println("TOTAL: $" + currentOrder.calculateTotalCost());
                System.out.print("Please enter cash AMOUNT: $");
                double userAmount = userScanner.nextDouble();
                double totalCost = currentOrder.calculateTotalCost();

                if (userAmount >= totalCost) {
                    double change = userAmount - totalCost;
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String formattegChange = decimalFormat.format(change);

                    System.out.println(userAmount  + " - " + totalCost + " = " + formattegChange);
                    System.out.println("Transaction COMPLETED.");
                    OrderManager.writeOrder(currentOrder);

                    currentOrder = null;

                    homeScreen();

                } else {
                    System.out.println("Insufficient payment amount. Please try again.");
                }
                break;

            case "a":
                orderScreen();
                break;

            case "r":
                System.out.println("Enter the NUMBER of the item to remove: ");
                int itemNumber = userScanner.nextInt();
                userScanner.nextLine();

                currentOrder.getOrderItems();

                if (itemNumber >= 1 && itemNumber <= orderList.size()){
                    OrderItem itemToRemove = orderList.get(itemNumber - 1);
                    currentOrder.removeItem(itemToRemove);
                    System.out.println("Item removed from your order.");
                }else{
                    System.out.println("Invalid item number. Please try again.");
                }

                break;

            case "x":
                System.out.println("Are you sure you want to cancel your order? (Y/N)");
                String cancelConfirmation = userScanner.nextLine();

                if (cancelConfirmation.equalsIgnoreCase("y")) {
                    System.out.println("Order canceled.Your cart has been cleared.");
                    currentOrder = null;
                    homeScreen();
                } else {
                    System.out.println("Order cancellation aborted.");
                }
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

    }

}