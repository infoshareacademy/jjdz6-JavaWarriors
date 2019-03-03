package com.infoshareacademy.pl.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        System.out.println("         ********           ");
        System.out.println("******** MENU-APP **********");
        System.out.println("* 1.  -- Register   --    * "); //RegisterForm.java
        System.out.println("* 2.  -- SingIn     --    * "); //SignInForm.java
        System.out.println("* 3.  -- Free User  --    * "); //FreeUserform.java
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
                        RegisterForm.registerFrom();
                        break;
                    case 2:
                        SingInForm.singInForm();
                        break;
                    case 3:
                        FreeUserform.freeUserform();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Błąd");

                }
                break;
            } catch (Exception e) {
                System.out.printf("!!ERROR!!");
                System.out.println("Wpisz jeszcze raz");
            }

        }
    }

}
