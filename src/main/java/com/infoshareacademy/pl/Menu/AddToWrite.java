package com.infoshareacademy.pl.Menu;

import java.io.FileWriter;
import java.io.IOException;

public class AddToWrite {

    public static void toWrite() {
        try {
            FileWriter addToWrite = new FileWriter("fileToSave.txt", true);
            addToWrite.write(SearchKeyWord.searchForKeyWorld());
            addToWrite.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }
}