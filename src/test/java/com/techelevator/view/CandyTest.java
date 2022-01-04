package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CandyTest {

    private Candy candyTest;

    @Before
    public void setup() {
        candyTest = new Candy("Wonka Bar", 1.50, 5);
    }

    @Test
    public void sound_return_test() {
        Assert.assertEquals("\"Munch Munch, Yum!\"", candyTest.getSound());
    }

    @Ignore ("Not significant to test")
    @Test
    public void return_price_as_string() {
        Assert.assertEquals("1.5", candyTest.getPriceAsString());
    }

    @Ignore ("Not relevant to test")
    @Test
    public void return_price_as_int_pennies_over_one_dollar() {
        assertEquals(150.0, candyTest.getPriceInPennies());
    }

    @Ignore ("Not relevant to test")
    @Test
    public void return_price_as_int_pennies_under_one_dollar() {
        candyTest = new Candy("Wonka Bar", 0.85, 5);

        assertEquals(85.0, candyTest.getPriceInPennies());
    }
}

