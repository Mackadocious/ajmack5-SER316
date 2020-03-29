package test.java;

import main.java.*;
import main.java.Alcohol;
import main.java.Dairy;
import main.java.Meat;
import main.java.UnderAgeException;
import org.junit.Test;
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

    Cart cart1;
    double cart1Expected;
    Cart cart2;
    double cart2Expected;
    Cart cart3;
    double cart3Expected;
    Cart cart4;
    double cart4Expected;
    Cart cart5;
    double cart5Expected;


    @org.junit.Before
    public void setUp() throws Exception {


        cart1Expected = 70.2;

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

    @Test
    public void calcProduce4() throws UnderAgeException {
        double amount = cart5.calcCost();
        assertEquals(cart5Expected, amount, .01);
    }




}