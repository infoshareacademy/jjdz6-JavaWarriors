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
        Integer[] tabOfnumebr = {0, 1, 2, 3, 4};
        Integer numberOfmenu = scanner.nextInt();
            switch (tabOfnumebr[numberOfmenu]) {
                case 1:
                    Person person = new Person();
                    person.setName();
                    person.setSurname();
                    person.setGender();
                    person.setEmail();
                    person.saveOnDisk();
                    break;
                case 2:
                    //metoda logowania//
                    break;
                case 3:
                   // FreeUser.writeOfname();
                   // FreeUser.writeEmail();
                    break;
                case  4:
                case 0:
                    break;
                    default:
                        System.out.println("koniec");


            }

        }
    }

