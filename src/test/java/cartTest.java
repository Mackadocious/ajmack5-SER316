import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.Produce;
import main.java.Cart;
import main.java.UnderAgeException;
import main.java.*;



import static org.junit.Assert.assertEquals;

public class cartTest {
    Cart cart2;
    double cart2Expected;
    Cart cart3;
    double cart3Expected;
    Cart cart4;
    double cart4Expected;
    Cart cart5;
    double cart5Expected;
    Cart cart6;
    double cart6Expected;
    Cart cart7;
    double cart7Expected;
    Cart cart8;
    double cart8Expected;
    Cart cart9;
    double cart9Expected;
    Cart cart10;
    double cart10Expected;
    Cart cart11;
    double cart11Expected;
    main.java.Cart cart12;
    double cart12Expected;
    main.java.Cart cart15;
    double cart15Expected;
    main.java.Cart cart16;



        main.java.Cart cart;

        @Before
        public void setUp() throws Exception {
            cart = new main.java.Cart(45);
            cart2 = new Cart(40);
            for (int i = 0; i < 4; i++) {
                cart2.addItem(new Produce());
            }
            cart2Expected = 1.0;

            cart3 = new Cart(19);
            for (int i = 0; i < 3; i++) {
                cart3.addItem(new Alcohol());

            }
            cart3Expected = 9.72;

            cart4 = new Cart(40);
            for (int i = 0; i < 2; i++) {
                cart4.addItem(new FrozenFood());

            }
            cart4Expected = 4.32;

            cart5 = new Cart(40);
            for (int i = 0; i < 3; i++) {
                cart5.addItem(new Dairy());

            }
            cart5Expected = 5.40;

            cart6 = new Cart(40);
            cart6.addItem(new Alcohol());
            cart6.addItem(new FrozenFood());



            cart7 = new Cart(21);
            cart7.addItem(new Meat());



            cart15 = new Cart(21);
            cart15.addItem(new Produce());
            cart15.addItem(new Produce());
            cart15.addItem(new Produce());
            cart15.addItem(new Produce());
            cart15.addItem(new Dairy());
            cart15.addItem(new Meat());
            cart15.addItem(new Alcohol());

            cart15.addItem(new main.java.FrozenFood());


            cart9 = new Cart(40);
            cart9.addItem(new main.java.Alcohol());
            cart9.addItem(new main.java.FrozenFood());
            cart9Expected = 10.80;

            cart10 = new Cart(40);
            for(int i = 0; i < 2; i++) {
                cart10.addItem(new main.java.Alcohol());
            }
            cart10.addItem(new main.java.FrozenFood());
            cart10Expected = 19.44;


            cart11 = new Cart(40);
            for(int i = 0; i < 2; i++) {
                cart11.addItem(new main.java.FrozenFood());
            }
            cart11.addItem(new main.java.Alcohol());
            cart11Expected = 16.20;

            cart12 = new Cart(40);

            cart12.addItem(new main.java.FrozenFood());
            cart12.addItem(new main.java.Meat());
            cart12.addItem(new main.java.Alcohol());
            cart12Expected = 21.6;
            cart16 = new Cart(35);
            cart16.addItem(new main.java.Alcohol());

            //Alcohol price: 8
            // Frozen food: 5
            // Alcohol + frozen food = 10

        }




        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void emptyCart() throws UnderAgeException{
            assertEquals(0.0, cart.Amount_saved(), .01);
        }

        @Test
        public void produceSavings()throws UnderAgeException{
            assertEquals(1.0, cart2.Amount_saved(), .01);
            assertEquals(7.56, cart2.calcCost(), .01);

        }

         @Test(expected = UnderAgeException.class)
            public void AlcoholAge() throws UnderAgeException {

            cart3.Amount_saved();

        }
    @Test(expected = UnderAgeException.class)
    public void AlcoholAge2() throws UnderAgeException {
        cart3.calcCost();


    }

         @Test
        public void FrozenFoodSavings()throws UnderAgeException{
        assertEquals(0.0, cart4.Amount_saved(), .01);
    }

    @Test
    public void DairySavings()throws UnderAgeException{
        assertEquals(0.0, cart5.Amount_saved(), .01);
    }

    @Test
    public void AlcandFrozenSavings()throws UnderAgeException{
        assertEquals(3.0, cart6.Amount_saved(), .01);
    }

    @Test
    public void taxCheck()throws UnderAgeException{
        assertEquals(0.80, cart7.getTax(10, "AZ"), .01);
        assertEquals(0.90, cart7.getTax(10, "CA"), .01);
        assertEquals(1.00, cart7.getTax(10, "NY"), .01);
        assertEquals(0.70, cart7.getTax(10, "CO"), .01);
        assertEquals(0.00, cart7.getTax(10, "AZf"), .01);
        }

    @Test
    public void fullCart() throws UnderAgeException{
        assertEquals(0.0, cart.Amount_saved(), .01);
    }

    @Test
    public void produceCalcCost() throws UnderAgeException{
        assertEquals(32.40, cart15.calcCost(), .01);
    }

    @Test
    public void remove() throws UnderAgeException{
            cart16.RemoveItem(cart16.cart.get(0));
        assertEquals(0.0, cart16.calcCost(), .01);
        cart16.RemoveItem(null);
        assertEquals(0.0, cart16.calcCost(), .01);
    }

    }


