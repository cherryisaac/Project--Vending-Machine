package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void return_price_as_string() {
        Assert.assertEquals("1.50", candyTest.getPriceAsString());
    }

    @Test
    public void return_price_as_int_pennies_over_one_dollar() {
        Assert.assertEquals(java.util.Optional.of(150), candyTest.getPriceInPennies());
    }

    @Test
    public void return_price_as_int_pennies_under_one_dollar() {
        candyTest = new Candy("Wonka Bar", 0.85, 5);

        Assert.assertEquals(java.util.Optional.of(85), candyTest.getPriceInPennies());
    }
}

