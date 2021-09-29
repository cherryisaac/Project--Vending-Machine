package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String fileName = "vendingmachine.csv";
    private File inventoryFile = new File(fileName);

    public List<String> getListOfAllLines() {
        List<String> dataLine = new ArrayList<String>();
        try (Scanner readFile = new Scanner(inventoryFile)) {
            while (readFile.hasNextLine()) {
                dataLine.add(readFile.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return dataLine;

    }

}
