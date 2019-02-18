package com.infoshareacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {



    public static void menu() throws FileNotFoundException {
        System.out.println("         ********           ");
        System.out.println("******** MENU-APP **********");
        System.out.println("* 1.  --  Zarejstruj się   -- * "); //Person.java
        System.out.println("* 2.  --  Zaloguj się      -- * "); //SignIn.java
        System.out.println("* 3.  --  Wolny użytkownik -- * "); //FreeUser.java
        System.out.println("* 4.  --                   -- * ");
        System.out.println("****************************");
        System.out.println("Wybierz z menu: ");
        Scanner scanner = new Scanner(System.in);
        Integer[] tabOfnumebr = {0, 1, 2, 3, 4}; Integer numberOfmenu = scanner.nextInt();
            switch (tabOfnumebr[numberOfmenu]) {
                case 1:
                    Person.writeOfname();
                    Person.writeOfsurname();
                    Person.isMaleorFamle();
                    Person.writeEmail();
                    break;
                case 2:
                  //metoda logowania//
                    break;
                case 3:
                    FreeUser.writeOfname();
                    FreeUser.writeEmail();
                    break;
                case 0:
                    break;

            }

        }
    }
