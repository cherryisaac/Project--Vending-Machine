package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    public TreeMap<String, Item> itemMap = new TreeMap<>();

    public List<String> getListOfAllLines() {
        try{
            return new ArrayList<>(Files.readAllLines(Path.of("vendingmachine.csv")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Inventory(FileReader fileReader) {
        /* create map file from vendingmachine.csv */
        //TreeMap<String, Item> inventoryMap = new TreeMap<String, Item>();
        File file = new File("vendingmachine.csv");
        for (String currentString : getListOfAllLines()) {
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
