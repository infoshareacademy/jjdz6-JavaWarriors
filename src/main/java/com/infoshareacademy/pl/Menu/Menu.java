package com.infoshareacademy.pl.Menu;

import twitter4j.TwitterException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException, TwitterException {
        System.out.println("         ********           ");
        System.out.println("******** MENU-APP ***************");
        System.out.println("* 1.  -- Szukaj           --    * "); //Search.java
        System.out.println("* 2.  -- Zarejestruj się  --    * "); //SignInForm.java
        System.out.println("*********************************");
        System.out.println("Wybierz z menu: ");
        Scanner scanner;
        while (true) {
            scanner = new Scanner(System.in);
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        Search.menuSecondSearch();
                        break;
                    case 2:
                        SingInForm.singInForm();
                        break;
                    default:
                        System.out.println("Błąd");

                }
                break;
            } catch (Exception e) {
                System.out.print("!!ERROR!!");
                System.out.println("Wpisz jeszcze raz");
            }

        }


    }


}
