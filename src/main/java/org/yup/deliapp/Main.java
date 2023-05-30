package org.yup.deliapp;
//DO NOT TOUCH OR ELSE .......
public class Main {
    public static void main(String[] args) {
        
        Drinks Customer1 = new Drinks("Large", DrinkFlavor.ORANGE_FANTA);
      //
        System.out.println(Customer1.getPrice("Large", DrinkFlavor.ORANGE_FANTA));
    }
}
