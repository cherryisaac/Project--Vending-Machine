package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

    private FileReader fileReaderTest;

    @Before
    public void setup() {
        fileReaderTest = new FileReader();
    }


    @Test
    public void name_at_A1_test() {
        Assert.assertEquals("Potato Crisps", fileReaderTest.createMapOfLocationAndItems().get("A1").getName());
    }


    @Test
    public void price_at_A1_test() {
        Assert.assertEquals("3.05", fileReaderTest.createMapOfLocationAndItems().get("A1").getPriceAsString());
    }

    @Test
    public void price_at_B2_test() {
        Assert.assertEquals("1.50", fileReaderTest.createMapOfLocationAndItems().get("B2").getPriceAsString());
    }

    @Test
    public void name_at_B2_test() {
        Assert.assertEquals("Cowtales", fileReaderTest.createMapOfLocationAndItems().get("B2").getName());
    }
}
