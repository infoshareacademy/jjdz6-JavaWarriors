package com.infoshareacademy.pl.Menu;

import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.RateLimitStatus;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchKeyWord {
    public static void toWriteInfoKey()  {
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter addToWrite = new FileWriter("fileToSaveKeySearching.txt", true);
            addToWrite.write(scanner.nextLine());
            addToWrite.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

}


