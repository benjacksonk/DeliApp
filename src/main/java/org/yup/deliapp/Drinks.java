package org.yup.deliapp;

public class Drinks extends OrderItem {
    private String size;
    private DrinkFlavor flavor;

    public Drinks(String size, DrinkFlavor flavor) {
        this.size = size;
        this.flavor = flavor;
    }
  
    public double getPrice(){
      double price;

      switch (size.toUpperCase()) {
          case "SMALL":
              price = 2.00;
              break;
          case "MEDIUM":
              price = 2.50;
              break;
          case "LARGE":
              price = 3.00;
              break;
          default:
              price = 0;
              break;
      }

      return price;

    }



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }
}
