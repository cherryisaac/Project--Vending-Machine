package com.techelevator.view;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
    private String fileName = "log.txt";
    private boolean deleteFile = new File(fileName).delete();
    private File logFile = new File(fileName);

    public Logger() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
    }

    public void logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
        String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
                afterTransaction);

        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n");
        } catch (IOException e1) {
            System.err.println(e1.getMessage());
        }


    }

}
