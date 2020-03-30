package test.java;

import main.java.*;
import main.java.Alcohol;
import main.java.Dairy;
import main.java.FrozenFood;
import main.java.Meat;
import main.java.UnderAgeException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import main.java.Cart;
import main.java.Cart1;
import main.java.Cart2;
import main.java.Cart3;
import main.java.Cart4;
import main.java.Cart5;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {Cart0.class},
            {Cart1.class},
            {Cart2.class},
            {Cart3.class},
            {Cart4.class},
            {Cart5.class}
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart


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
    Cart cart12;
    double cart12Expected;




    @org.junit.Before
    public void setUp() throws Exception {




        cart2 = createCart(40);
            for (int i = 0; i < 6; i++) {
                cart2.addItem(new Produce());
            }
                cart2Expected = 10.80;

        cart3 = createCart(40);
        for (int i = 0; i < 5; i++) {
            cart3.addItem(new Produce());

        }
        cart3Expected = 9.72;

        cart4 = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart4.addItem(new Produce());

        }
        cart4Expected = 4.32;

        cart5 = createCart(40);
        for (int i = 0; i < 3; i++) {
            cart5.addItem(new Produce());

        }
        cart5Expected = 5.40;

        cart6 = createCart(40);
            cart6.addItem(new Alcohol());



        cart7 = createCart(21);
            cart7.addItem(new Alcohol());



        cart8 = createCart(20);
            cart8.addItem(new Alcohol());

        cart9 = createCart(40);
            cart9.addItem(new Alcohol());
            cart9.addItem(new FrozenFood());
            cart9Expected = 10.80;

        cart10 = createCart(40);
            for(int i = 0; i < 2; i++) {
                cart10.addItem(new Alcohol());
            }
            cart10.addItem(new FrozenFood());
            cart10Expected = 19.44;


        cart11 = createCart(40);
            for(int i = 0; i < 2; i++) {
                cart11.addItem(new FrozenFood());
            }
            cart11.addItem(new Alcohol());
            cart11Expected = 16.20;

        cart12 = createCart(40);

            cart12.addItem(new FrozenFood());
            cart12.addItem(new Meat());
            cart12.addItem(new Alcohol());
            cart12Expected = 21.6;

            //Alcohol price: 8
            // Frozen food: 5
            // Alcohol + frozen food = 10

    }



        //Test Case:
        //
        //Test whether the discount is applied to all groups of 3 produce items
        //
        //
        //Amount is divisible by 3 and greater than 3

        @Test
        public void calcProduce1() throws UnderAgeException {
            double amount = cart2.calcCost();
            assertEquals(cart2Expected, amount, .01);
        }

    //Test Case:
    //
    //Test whether the discount is applied to all groups of 3 produce items
    //
    //
    //Amount not divisible by 3 but greater than 3

    @Test
    public void calcProduce2() throws UnderAgeException {
        double amount = cart3.calcCost();
        assertEquals(cart3Expected, amount, .01);
    }
    //Test Case:
    //
    //Test whether the discount is applied to all groups of 3 produce items
    //
    //
    //Amount less than 3
    @Test
    public void calcProduce3() throws UnderAgeException {
        double amount = cart4.calcCost();
        assertEquals(cart4Expected, amount, .01);
    }
    //Test Case:
    //
    //Test whether the discount is applied to all groups of 3 produce items
    //
    //
    //Amount Exactly 3
    @Test
    public void calcProduce4() throws UnderAgeException {
        double amount = cart5.calcCost();
        assertEquals(cart5Expected, amount, .01);
    }

    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age > 21
    @Test(expected = Test.None.class)
    public void AlcoholAge1() throws UnderAgeException {
        cart6.calcCost();

    }
    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age == 21
    @Test(expected = Test.None.class)
    public void AlcoholAge2() throws UnderAgeException {
        cart7.calcCost();
    }

    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age < 21
    @Test(expected = UnderAgeException.class)
    public void AlcoholAge3() throws UnderAgeException {
        cart8.calcCost();
    }

    @Test
    public void calcFrozenAlc1() throws UnderAgeException {
        double amount = cart9.calcCost();
        assertEquals(cart9Expected, amount, .01);
    }

    @Test
    public void calcFrozenAlc2() throws UnderAgeException {
        double amount = cart10.calcCost();
        assertEquals(cart10Expected, amount, .01);
    }
    @Test
    public void calcFrozenAlc3() throws UnderAgeException {
        double amount = cart11.calcCost();
        assertEquals(cart11Expected, amount, .01);
    }
    @Test
    public void calcFrozenAlc4() throws UnderAgeException {
        double amount = cart12.calcCost();
        assertEquals(cart12Expected, amount, .01);
    }




}