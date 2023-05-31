import org.yup.deliapp.PremiumToppings;

public class Cheese extends PremiumToppings {

    @Override
    public double getPrice(int subSize) {
        double cheesePrice;
        double extraCheesePrice;


        switch (subSize) {
            case 4:
                cheesePrice = .75;
                extraCheesePrice = .30;
                break;
            case 8:
                cheesePrice = 1.50;
                extraCheesePrice = .60;
                break;
            case 12:
                cheesePrice = 2.25;
                extraCheesePrice = .90;
                break;
            default:
                // Handle invalid sub sizes or additional logic if needed
                return 0.0;
    }

        if (isHasExtra()) {
            return cheesePrice + extraCheesePrice ;
        } else {
            return cheesePrice;
        }
    }
}
