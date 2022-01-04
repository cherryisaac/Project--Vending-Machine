package com.techelevator.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* reads through all lines of the file vendingmachine.csv
*  stores output String into a list called dataLine and return dataLine when used*/

public class FileReader {
    public List<String> getListOfAllLines() {
        try{
          return new ArrayList<>(Files.readAllLines(Path.of("vendingmachine.csv")));
        } catch (IOException e ) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
