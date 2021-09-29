package com.techelevator.view;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    //private FileReader fileReader;
    public TreeMap<String, Item> itemMap = new TreeMap<>();

    public Inventory(FileReader fileReader) {
        /* create map file from vendingmachine.csv */
        //TreeMap<String, Item> inventoryMap = new TreeMap<String, Item>();
        for (String currentString : fileReader.getListOfAllLines()) {
            /*** index array 0-3
             0  1             2    3
             A1|Potato Crisps|3.05|Chip
             */
            String[] tempArray = currentString.split("\\|");
            if (tempArray[3].equals("Candy")) {
                Candy candy = new Candy(tempArray[1], Double.parseDouble(tempArray[2]), 5);
                itemMap.put(tempArray[0], candy);
            } else if (tempArray[3].equals("Chip")) {
                Chip chip = new Chip(tempArray[1], Double.parseDouble(tempArray[2]), 5);
                itemMap.put(tempArray[0], chip);
            } else if (tempArray[3].equals("Drink")) {
                Drink drink = new Drink(tempArray[1], Double.parseDouble(tempArray[2]), 5);
                itemMap.put(tempArray[0], drink);
            } else if (tempArray[3].equals("Gum")) {
                Gum gum = new Gum(tempArray[1], Double.parseDouble(tempArray[2]), 5);
                itemMap.put(tempArray[0], gum);
            }

        }
    }

    public int returnCurrentQty(String slotLocation) {
        return itemMap.get(slotLocation).getQuantity();
    }

    public Map<String, Item> stock() {
        return itemMap;
    }

}
