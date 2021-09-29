package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class VendingMachineTest {
    private Inventory vendingMachineInventory;
    private CoinBox vendingMachineCoinBox;
    private FileReader vendingMachineFileReader;
    private VendingMachine vendingMachineTest;

    @Before
    public void setup() throws IOException {
        vendingMachineFileReader = new FileReader();
        vendingMachineInventory = new Inventory(vendingMachineFileReader);
        vendingMachineTest = new VendingMachine(vendingMachineInventory);
        vendingMachineCoinBox = new CoinBox();
    }

    @Test
    public void purchase_item_not_on_map() throws IOException {
        Assert.assertEquals("Please Make A Valid Selection", vendingMachineTest.purchaseItem("B52"));
    }



}
