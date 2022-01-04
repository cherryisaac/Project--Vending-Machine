package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CoinBoxTest {

    private CoinBox coinBoxTest;

    @Before
    public void setup() {
        coinBoxTest = new CoinBox();
    }


    @Test
    public void correct_amount_deposited() {
        coinBoxTest.addMoney(Double.valueOf(1));
        assertEquals(100.0, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void correct_amount_deposited_5() {
        coinBoxTest.addMoney(Double.valueOf(5));
        assertEquals(500.0, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void correct_amount_withdraw() {
        coinBoxTest.addMoney(Double.valueOf(1));
        coinBoxTest.withdrawMoney(Double.valueOf(25));
        assertEquals(75.0, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void balance_is_set_to_zero_by_default() {
        assertEquals(0.0, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void return_one_dollar_as_coins_zero_balance() {
        coinBoxTest.addMoney(Double.valueOf(1));
        Assert.assertEquals("Your change is 4 quarters, 0 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
        assertEquals(0.0, coinBoxTest.getBalanceInPennies());
    }
    @Test
    public void return_one_dollar_as_coins() {
        coinBoxTest.addMoney(Double.valueOf(1));
        Assert.assertEquals("Your change is 4 quarters, 0 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
    }



    @Test
    public void return_one_dollar_twenty_as_coins() {
        coinBoxTest.addMoney(Double.valueOf(2));
        coinBoxTest.withdrawMoney(Double.valueOf(80));
        Assert.assertEquals("Your change is 4 quarters, 2 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
    }

    @Test
    public void return_one_thirty_five_as_coins() {
        coinBoxTest.addMoney(Double.valueOf(2));
        coinBoxTest.withdrawMoney(Double.valueOf(65));
        Assert.assertEquals("Your change is 5 quarters, 1 dimes, and 0 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
    }

    @Test
    public void return_fifteen_cents_as_coins() {
        coinBoxTest.addMoney(Double.valueOf(1));
        coinBoxTest.withdrawMoney(Double.valueOf(85));
        Assert.assertEquals("Your change is 0 quarters, 1 dimes, and 1 nickels.", coinBoxTest.returnChangeAsCoins(coinBoxTest.getBalanceInPennies()));
    }


    @Test
    public void current_balance_is_correct() {
        coinBoxTest.addMoney(Double.valueOf(1));
        coinBoxTest.withdrawMoney(Double.valueOf(25));
        assertEquals(75.0, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void current_balance_to_string() {
        coinBoxTest.addMoney(Double.valueOf(2));
        coinBoxTest.withdrawMoney(Double.valueOf(20));
        Assert.assertEquals("$1.80", coinBoxTest.getBalanceAsString());
    }

    @Test
    public void current_balance_to_string_two() {
        coinBoxTest.addMoney(Double.valueOf(1));
        coinBoxTest.withdrawMoney(Double.valueOf(20));
        Assert.assertEquals("$0.80", coinBoxTest.getBalanceAsString());
    }

    @Test
    public void current_balance_to_string_three() {
        coinBoxTest.addMoney(Double.valueOf(11));
        coinBoxTest.withdrawMoney(Double.valueOf(20));
        Assert.assertEquals("$10.80", coinBoxTest.getBalanceAsString());
    }
}
