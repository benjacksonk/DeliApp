package org.yup.deliapp;

public class Drinks {
    private String size;
    private DrinkFlavor flavor;

    public Drinks(String size, DrinkFlavor flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getPrice(String drinkSize, DrinkFlavor flavor){
      double price = 0;
        if(drinkSize.equals("Small")){
          price = 2.00;
        } else if (drinkSize.equals("Medium")){
            price = 2.50;
        } else if (drinkSize.equals("Large")){
            price = 3.00;
        } else {
          return  "Please choose appropriate size";
        }
        return "Here is the cost of your drink: " +  drinkSize + " " + flavor + "  " + price + "$";
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
