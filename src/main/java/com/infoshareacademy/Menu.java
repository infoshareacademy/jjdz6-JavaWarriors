package com.infoshareacademy;

import java.io.*;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        System.out.println("         ********           ");
        System.out.println("******** MENU-APP **********");
        System.out.println("* 1.  --  Zarejstruj się   -- * "); //Person.java
        System.out.println("* 2.  --  Zaloguj się      -- * "); //SignIn.java
        System.out.println("* 3.  --  Wolny użytkownik -- * "); //FreeUser.java
        System.out.println("* 4.  --    Pokaż dane     -- * ");
        System.out.println("****************************");
        System.out.println("Wybierz z menu: ");
        Scanner scanner = new Scanner(System.in);
        Integer numberOfMenuSc;
        boolean isNot = true;
        while (isNot) {
            scanner = new Scanner(System.in);
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        Person person = new Person();
                        person.setName();
                        person.setSurname();
                        person.setGender();
                        person.setEmail();
                        // person.saveOnDisk();
                        break;
                    case 2:
                        //metoda logowania//
                        break;
                    case 3:
                       FreeUser freeUser = new FreeUser();
                       freeUser.setName();
                       freeUser.setEmail();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("koniec");

                }
                break;
            } catch (Exception e) {
                System.out.printf("!!ERROR!!");
                System.out.println("Wpisz jeszcze raz");
            }

        }
    }

}
