package com.infoshareacademy;

import java.util.Scanner;

public class Menu {


   public  static  void  menu() {
       System.out.println("         ^^^^^^^^          ");
       System.out.println("******** MENU-APP *********");
       System.out.println("*         ********        * ");
       System.out.println("* 1.     Username         * ");
       System.out.println("* 2.     Post Code        * ");
       System.out.println("* 3.       City           * ");
       System.out.println("* 4.      Gender          * ");
       System.out.println("***************************");
       System.out.println("Wybierz z menu: ");
       Scanner scanner = new Scanner(System.in);
       Integer[] tabOfnumebr = {0, 1, 2, 3, 4};
       Integer numberOfmenu = scanner.nextInt();
       if (tabOfnumebr[numberOfmenu] == 1) {
           System.out.println("Write your name: ");
           Scanner scanner1 = new Scanner(System.in);
           String name = scanner1.nextLine();
           System.out.println("Username: " + name);
       } else if (tabOfnumebr[numberOfmenu] == 2) {
           System.out.println("Write your Post Code: ");
           Scanner scanner2 = new Scanner(System.in);
           Integer postCode = scanner2.nextInt();
           System.out.println("Postcode: " + postCode);
       }



   }

}
