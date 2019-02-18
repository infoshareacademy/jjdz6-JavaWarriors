package com.infoshareacademy;

import java.util.Scanner;

public class Menu {


    public static void menu() {
        System.out.println("         ********           ");
        System.out.println("******** MENU-APP **********");
        System.out.println("* 1.  --  Person  --      * ");
        System.out.println("* 2.  -- Post Code --      * ");
        System.out.println("* 3.  --   City    --      * ");
        System.out.println("* 4.  --  Gender   --      * ");
        System.out.println("****************************");
        System.out.println("Wybierz z menu: ");
        Scanner scanner = new Scanner(System.in);
        Integer[] tabOfnumebr = {0, 1, 2, 3, 4}; Integer numberOfmenu = scanner.nextInt();
            switch (tabOfnumebr[numberOfmenu]) {
                case 1:
                    Person.writeOfname();
                    Person.writeOfsurname();
                    Person.isMaleorFamle();
                case 2:
                    System.out.println("Write your Post Code: ");
                    Scanner scanner2 = new Scanner(System.in);
                    Integer postCode = scanner2.nextInt();
                    System.out.println("Post Code: " + postCode);
                case 3:
                    System.out.println("***********************");
                    System.out.println("Write your City: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String city = scanner3.nextLine();
                    System.out.println("City: " + city);
                case 0:
                    break;

            }

        }
    }
