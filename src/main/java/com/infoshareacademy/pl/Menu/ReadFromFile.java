package com.infoshareacademy.pl.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    public static void readFromFile() {

        try {
            File file = new File("fileToSave.txt");
            Scanner readSc = new Scanner(file);
            while (readSc.hasNextLine()) {

                String someDate = readSc.nextLine();
                System.out.println(someDate);
            }
            readSc.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
