package org.yup.deliapp;

import java.util.ArrayList;
import java.util.Scanner;

//DO NOT TOUCH
public class Screens {

    static Scanner userScanner = new Scanner(System.in);
    static ArrayList<String> orderList = new ArrayList<>();

    public static String homeScreen(){

        System.out.println("Please choose from the following OPTIONS: ");
        System.out.println("\tO * NEW ORDER");
        System.out.println("\tX * EXIT");
        System.out.print("Please enter your selection: ");
        return userScanner.nextLine();

    }

    public static void orderScreen(){

        System.out.println("Please choose from the following OPTIONS: ");
        System.out.println("\tS * Add SANDWICH");
        System.out.println("\tC * Add CHIPS");
        System.out.println("\tD * Add DRINKS");
        System.out.println("\tV * To VIEW Order");
        System.out.println("\tX * CANCEL Order");
        System.out.println("\tH * Back to HOME screen");
        System.out.println("Please ENTER your selection: ");
        String orderScreenChoice = userScanner.nextLine();


        switch (orderScreenChoice.toLowerCase()){
            case "s":
                break;
            case "c":
                break;
            case "d":
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
    }

    public static void cancelOrder(){
        orderList.clear();
        System.out.println("Your order has been successfully CANCELED");
        homeScreen();

    }
}
