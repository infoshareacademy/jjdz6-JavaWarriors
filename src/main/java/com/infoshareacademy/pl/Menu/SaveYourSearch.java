package com.infoshareacademy.pl.Menu;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class SaveYourSearch {

    public static void writeMethod  (String text) throws IOException {
       BufferedWriter output = null;
        try {
            File file = new File("dane.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }
}


