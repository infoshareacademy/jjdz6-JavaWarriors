package com.infoshareacademy.pl.Menu;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void saveYourSearch() {
        try {
            File fileSaveYourSearch = new File("fileToSave.txt");
            if (fileSaveYourSearch.createNewFile()) {
                System.out.println("File created: " + fileSaveYourSearch.getName());
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

}


