package test.java;

import main.java.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * The type Black box given.
 */
@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<Cart> classUnderTest;

    /**
     * Instantiates a new Black box given.
     *
     * @param classUnderTest the class under test
     */
    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    /**
     * Cart class under test collection.
     *
     * @return the collection
     */
    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
                {Cart0.class
                },
                {Cart1.class
                },
                {Cart2.class
                },
                {Cart3.class
                },
                {Cart4.class
                },
                {Cart5.class
                }
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart


    /**
     * The Cart 2.
     */
    Cart cart2;
    /**
     * The Cart 2 expected.
     */
    double cart2Expected;
    /**
     * The Cart 3.
     */
    Cart cart3;
    /**
     * The Cart 3 expected.
     */
    double cart3Expected;
    /**
     * The Cart 4.
     */
    Cart cart4;
    /**
     * The Cart 4 expected.
     */
    double cart4Expected;
    /**
     * The Cart 5.
     */
    Cart cart5;
    /**
     * The Cart 5 expected.
     */
    double cart5Expected;
    /**
     * The Cart 6.
     */
    Cart cart6;
    /**
     * The Cart 6 expected.
     */
    /**
     * The Cart 7.
     */
    Cart cart7;
    /**
     * The Cart 7 expected.
     */
    /**
     * The Cart 8.
     */
    Cart cart8;
    /**
     * The Cart 8 expected.
     */
    /**
     * The Cart 9.
     */
    Cart cart9;
    /**
     * The Cart 9 expected.
     */
    double cart9Expected;
    /**
     * The Cart 10.
     */
    Cart cart10;
    /**
     * The Cart 10 expected.
     */
    double cart10Expected;
    /**
     * The Cart 11.
     */
    Cart cart11;
    /**
     * The Cart 11 expected.
     */
    double cart11Expected;
    /**
     * The Cart 12.
     */
    Cart cart12;
    /**
     * The Cart 12 expected.
     */
    double cart12Expected;


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
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
        for (int i = 0; i < 2; i++) {
            cart10.addItem(new Alcohol());
        }
        cart10.addItem(new FrozenFood());
        cart10Expected = 19.44;


        cart11 = createCart(40);
        for (int i = 0; i < 2; i++) {
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

    /**
     * Calc produce 1.
     *
     * @throws UnderAgeException the under age exception
     */
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

    /**
     * Calc produce 2.
     *
     * @throws UnderAgeException the under age exception
     */
    @Test
    public void calcProduce2() throws UnderAgeException {
        double amount = cart3.calcCost();
        assertEquals(cart3Expected, amount, .01);
    }

    /**
     * Calc produce 3.
     *
     * @throws UnderAgeException the under age exception
     */
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

    /**
     * Calc produce 4.
     *
     * @throws UnderAgeException the under age exception
     */
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

    /**
     * Alcohol age 1.
     *
     * @throws UnderAgeException the under age exception
     */
    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age > 21
    @Test(expected = Test.None.class)
    public void alcoholAge_1() throws UnderAgeException {
        cart6.calcCost();

    }

    /**
     * Alcohol age 2.
     *
     * @throws UnderAgeException the under age exception
     */
    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age == 21
    @Test(expected = Test.None.class)
    public void alcoholAge_2() throws UnderAgeException {
        cart7.calcCost();
    }

    /**
     * Alcohol age 3.
     *
     * @throws UnderAgeException the under age exception
     */
    //Test Case: Test whether alcohol is able to be sold to users with certain ages
    //
    //
    //Age < 21
    @Test(expected = UnderAgeException.class)
    public void alcoholAge_3() throws UnderAgeException {
        cart8.calcCost();
    }

    /**
     * Calc frozen alc 1.
     *
     * @throws UnderAgeException the under age exception
     */
    @Test
    public void calcFrozenAlc1() throws UnderAgeException {
        double amount = cart9.calcCost();
        assertEquals(cart9Expected, amount, .01);
    }

    /**
     * Calc frozen alc 2.
     *
     * @throws UnderAgeException the under age exception
     */
    @Test
    public void calcFrozenAlc2() throws UnderAgeException {
        double amount = cart10.calcCost();
        assertEquals(cart10Expected, amount, .01);
    }

    /**
     * Calc frozen alc 3.
     *
     * @throws UnderAgeException the under age exception
     */
    @Test
    public void calcFrozenAlc3() throws UnderAgeException {
        double amount = cart11.calcCost();
        assertEquals(cart11Expected, amount, .01);
    }

    /**
     * Calc frozen alc 4.
     *
     * @throws UnderAgeException the under age exception
     */
    @Test
    public void calcFrozenAlc4() throws UnderAgeException {
        double amount = cart12.calcCost();
        assertEquals(cart12Expected, amount, .01);
    }


}