package org.yup.deliapp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Screens {

    static Scanner userScanner = new Scanner(System.in); //static scanner - will be able to use it throughout the class
    static ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();

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
        orderList.clear();
        System.out.println("Your order has been successfully CANCELED");
        homeScreen();

    }

    public static void drinkOrder(){
        System.out.println("Please choose from the following FLAVORS: ");

        for ( DrinkFlavor drinkFlavor : DrinkFlavor.values()) {
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
                orderList.add(drinkChoice);


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
            orderList.add(chipOrder);


        }catch(IllegalArgumentException e){
            System.out.println("Invalid chip choice. Please try again");
            chipOrder();
        }

    }

    public static void sandwichOrder(){
        System.out.println("Please choose the SIZE of your sandwich: ");
        System.out.println("Please choose the type of BREAD: ");
        System.out.println("Did you want your bread TOASTED? (Y/N)");
        System.out.println("Please choose which MEAT: ");
        System.out.println("Please choose which CHEESE: ");
        System.out.println("Please choose which FREE TOPPING: ");

    }

    public static void viewOrder(){
        OrderManager.readOrder();
        System.out.println("Please choose from the following options: ");
        System.out.println("P * to CHECKOUT and PAY");
        System.out.println("A * to ADD to your order");
        System.out.println("R * to REMOVE item from your order");
        System.out.println("X * to CANCEL your order");
        String viewOrderChoice = userScanner.nextLine();

        switch (viewOrderChoice.toLowerCase()){
            case "p":
                break;

            case "a":
                break;

            case "r":
                break;

            case "x":
                break;
        }

    }

}
