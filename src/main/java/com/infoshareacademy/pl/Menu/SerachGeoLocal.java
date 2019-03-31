package com.infoshareacademy.pl.Menu;

import twitter4j.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SerachGeoLocal {
    public static void toWriteInfoGeo () {
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter addToWrite = new FileWriter("fileToSaveGeoSearching.txt", true);
            addToWrite.write(scanner.nextLine());
            addToWrite.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        }
}
