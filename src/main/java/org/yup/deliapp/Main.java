package org.yup.deliapp;
//DO NOT TOUCH OR ELSE .......
public class Main {
    public static void main(String[] args) {

        deliApp(); //calls in the method below

    }

    public static void deliApp(){

        System.out.println("WELCOME to DELIcious Sandwiches!");

        boolean appRunning = true;

        while (appRunning) {

            String homeScreenChoice = Screens.homeScreen(); //calls in homeScreen method in Screens class

            switch (homeScreenChoice.toLowerCase()) {
                case "o":
                    System.out.println(Screens.orderScreen()); //calls in orderScreen method in Screens class
                    appRunning = false;
                    break;

                case "x":
                    System.out.println("Thank you and come again!");
                    appRunning = false; //Stops the app
                    break;

                default:
                    System.out.println("Please choose a VIABLE option.\n");
                    break;
            }
        }
    }
}
