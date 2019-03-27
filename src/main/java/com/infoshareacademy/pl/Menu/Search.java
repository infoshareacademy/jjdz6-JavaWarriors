package com.infoshareacademy.pl.Menu;

import java.util.Scanner;

public class Search {

    public static void menuSecondSearch() {
        System.out.println("Menu Search: ");
        System.out.println("1: Search KeyWord");
        System.out.println("2: Search GeoLocal2");
        boolean isNot = true;
        while (isNot) {
           Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    SearchKeyWord.searchForKeyWorld();
                    break;
                case 2:
                    SerachGeoLocal.searchOfGeo();
                break;
                case 3:




            }

            break;
        }

    }
}