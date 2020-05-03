package main.java;

import main.java.Alcohol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import main.java.FrozenFood;
import main.java.Product;
public class Cart {

    public List<Product> cart;
    protected int userAge;
    //’SER316 TASK 2 SPOTBUGS FIX’ in all CAPS

    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<Product>();
    }

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
     *
     * @return double totalCost
     * @throws UnderAgeException
     */
    public double calcCost() throws UnderAgeException {


        int dairyCount = parseDairyProducts(cart);
        int meatCount = parseMeatProducts(cart);
        int produceCount = 0;
        int alcoholcount = parseAlcoholProducts(cart);
        int frozencount = 0;
        int alcoholandFrozencount = 0;
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {



            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                produceCount += 1;

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
    public int Amount_saved() throws main.java.UnderAgeException {
        int subTotal = 0;
        int costAfterSavings = 0;

        double produce_counter = 0;
        int alcoholCounter = parseAlcoholProducts(cart);
        int frozenFoodCounter = parseFrozenProducts(cart);
        int dairyCounter = parseDairyProducts(cart);


        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();
            costAfterSavings = costAfterSavings + cart.get(i).getCost();

            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                produce_counter++;

                if (produce_counter >= 3) {
                    costAfterSavings -= 1;
                    produce_counter = 0;
                }
            }

        }

            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                costAfterSavings = costAfterSavings - 3;
                alcoholCounter--;
                frozenFoodCounter--;
            }



        return subTotal - costAfterSavings;
    }

      int parseFrozenProducts(List<Product> cart) {
        ArrayList<Product> frozenFood = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                frozenFood.add(cart.get(i));
            }
        }
        return frozenFood.size();
    }

    int parseDairyProducts(List<Product> cart) {
        ArrayList<Product> dairyProducts = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass().toString().equals(main.java.Dairy.class.toString())) {
                dairyProducts.add(cart.get(i));
            }
        }
        return dairyProducts.size();
    }

    int parseMeatProducts(List<Product> cart) {
        ArrayList<Product> dairyProducts = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass().toString().equals(main.java.Meat.class.toString())) {
                dairyProducts.add(cart.get(i));
            }
        }
        return dairyProducts.size();
    }

    int parseAlcoholProducts(List<Product> cart) throws main.java.UnderAgeException {
        ArrayList<Product> alcoholProducts = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                alcoholProducts.add(cart.get(i));
            }
        }
        if (userAge < 21 && alcoholProducts.size() > 0){

                throw new main.java.UnderAgeException("The user is not of age to buy alcohol");
        }
        return alcoholProducts.size();
    }

    Map<String, Double> createHashMap(){
        HashMap<String, Double> taxes = new HashMap<String, Double>();
        taxes.put("AZ", 0.08);
        taxes.put("CA", 0.09);
        taxes.put("NY", 0.1 );
        taxes.put("CO", 0.07);
        return taxes;
    }

    // Gets the tax based on state and the total
    public double getTax(double totalBT, String twoLetterUSStateAbbreviation) {
        Map<String, Double> taxes = createHashMap();

        double newTotal = 0;
        if (taxes.containsKey(twoLetterUSStateAbbreviation)) {
            newTotal = totalBT * taxes.get(twoLetterUSStateAbbreviation);
            return newTotal;
        } else {
            return 0.00;


        }
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
}
