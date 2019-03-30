package com.infoshareacademy.pl.Menu;

import java.util.Scanner;

public class Search {

    public static void menuSecondSearch() {
        System.out.println("   Menu Search:    ");
        System.out.println("1. Search KeyWord  ");
        System.out.println("2. Search GeoLocal ");
        System.out.println("3. Open KeyWorld ");
        System.out.println("4. Open Geolocal");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                switch (scanner.nextInt()) {
                    case 1:
                        SearchKeyWord.toWriteInfoKey();
                        break;
                    case 2:
                        SerachGeoLocal.toWriteInfoGeo();
                        break;
                    case 3:
                        SearchKeyWord.readFromFileKey();
                        break;
                    case 4:
                        SearchKeyWord.readFromFileGeo();
                    default:
                        System.out.println("Dziękujemy");


                }

                break;
            } catch (Exception e) {
                System.out.println("Błąd Wpisz jeszcze raz");
            }

        }
    }
}