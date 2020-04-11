package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    protected int userAge;
    public List<Product> cart;
   //’SER316 TASK 2 SPOTBUGS FIX’ in all CAPS

    /**
     * Calculates the final cost after all savings and tax has been applied. Also checks
     * that the user is of age to purchase alcohol if it is in their cart at checkout.
     * Sales tax is always AZ tax.
     * Calculation is based off of the following prices and deals:
     * Dairy -> $3
     * Meat -> $10
     * Produce -> $2 or 3 for $5
     * Alcohol -> $8
     * Frozen Food -> $5
     * Alcohol + Frozen Food -> $10
     * If there is an alcohol product in the cart and the user is under 21, then an
     * UnderAgeException should be thrown.
     * @return double totalCost
     * @throws UnderAgeException
     */
    public double calcCost() throws UnderAgeException {


        int dairyCount = 0;
        int meatCount = 0;
        int produceCount = 0;
        int alcoholcount = 0;
        int frozencount = 0;
        int alcoholandFrozencount = 0;
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {


            if (cart.get(i).getClass().toString().equals(Dairy.class.toString())) {
                dairyCount += 1;


            }
            if (cart.get(i).getClass().toString().equals(Meat.class.toString())) {

                meatCount += 1;

            }

            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                produceCount += 1;

            }
            if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                if (userAge < 21) {
                    throw new UnderAgeException("The User is not of age to purchase alcohol!");
                } else {
                    alcoholcount++;
                }
            }
            if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                frozencount++;
            }


        }


        total += dairyCount * 3;
        total += meatCount * 10;

        if (produceCount > 2) {
            int leftoverProduce = produceCount % 3;
            produceCount = ((produceCount - leftoverProduce) / 3);
            total += leftoverProduce * 2;
            total += produceCount * 5;

        } else {
            total += produceCount * 2;
        }

        if (alcoholcount > 0 && frozencount > 0) {
            while (frozencount != 0 && alcoholcount != 0) {
                frozencount--;
                alcoholcount--;
                alcoholandFrozencount++;

            }
        }

        total += frozencount * 5;
        total += alcoholcount * 8;
        total += alcoholandFrozencount * 10;


        total = total + getTax(total, "AZ");


        return total;
    }

    // calculates how much was saved in the current shopping cart based on the deals, returns the saved amount
    // throws exception if alcohol is bought from underage person
    // TODO: Create node graph for this method in assign 4: create white box tests and fix the method, reach at least 98% coverage
    public int Amount_saved() throws UnderAgeException {
        int subTotal = 0;
        int costAfterSavings = 0;

        double produce_counter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0;
        int dairyCounter = 0;

        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();
            costAfterSavings = costAfterSavings + cart.get(i).getCost();

            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                produce_counter++;

                if (produce_counter >= 3) {
                    costAfterSavings -= 1;
                    produce_counter = 0;
                }
            } else if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                alcoholCounter++;
                if (userAge < 21) {
                    throw new UnderAgeException("The User is not of age to purchase alcohol!");
                }
            } else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                frozenFoodCounter++;
            } else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString()))
                dairyCounter++;

            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                costAfterSavings = costAfterSavings - 3;
                alcoholCounter--;
                frozenFoodCounter--;
            }
        }

        return subTotal - costAfterSavings;
    }

    // Gets the tax based on state and the total
    public double getTax(double totalBT, String twoLetterUSStateAbbreviation) {
        double newTotal = 0;
        switch (twoLetterUSStateAbbreviation) {
            case "AZ":
                newTotal = totalBT * .08;
                break;
            case "CA":
                newTotal = totalBT * .09;
                break;
            case "NY":
                newTotal = totalBT * .1;
                break;
            case "CO":
                newTotal = totalBT * .07;
                break;
            default:
                return 0.00;
        }
        return newTotal;
    }

    public void addItem(Product np) {
        cart.add(np);
    }

 //’SER316 TASK 2 SPOTBUGS FIX’ in all CAPS
 public boolean removeItem(Product productToRemove) {
        boolean test = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i) == productToRemove) {
                cart.remove(i);
                test = true;
                return test;
            }
        }
        return false;
    }

    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<Product>();
    }
}
