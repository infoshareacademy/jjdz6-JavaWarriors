package com.infoshareacademy.pl.Menu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateNewFile {
    public static void createKeySave() {
        try {
            File fileSaveYourSearchKey = new File("fileToSaveKeySearching.txt");
            if (fileSaveYourSearchKey.createNewFile()) {
                System.out.println("File created: " + fileSaveYourSearchKey.getName());
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public static void createGeoKey() {

try {
        File fileSaveyourSearchGeo = new File("fileToSaveGeoSearching.txt");
        if (fileSaveyourSearchGeo.createNewFile()) {
            System.out.println("File created: " + fileSaveyourSearchGeo.getName());
        } else {
            System.out.println("File already exist");
        }
    } catch (IOException e) {
        System.out.println("An error occured");
        e.printStackTrace();
    }


    }
}

