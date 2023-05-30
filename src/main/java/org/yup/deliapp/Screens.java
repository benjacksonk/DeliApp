package org.yup.deliapp;

import java.util.ArrayList;
import java.util.Scanner;

//DO NOT TOUCH
public class Screens {

    static Scanner userScanner = new Scanner(System.in); //static scanner - will be able to use it throughout the class
    static ArrayList<OrderItem> orderList = new ArrayList<>();

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
                break;
            case "c":
                break;
            case "d":
                drinkOrder();
                break;

            case "v":
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

}
