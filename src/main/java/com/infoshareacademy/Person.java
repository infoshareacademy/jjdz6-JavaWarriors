package com.infoshareacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Person {


    public static void writeOfname() throws FileNotFoundException {
        Scanner writeOfnameSc = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Write yours name: ");
        String name = writeOfnameSc.nextLine();
        System.out.println("Yours name: " + name);
        PrintWriter zapis = new PrintWriter("dane.txt");
        zapis.println("name: " + name);
        zapis.close();

    }


    public static void writeOfsurname() throws FileNotFoundException {
        Scanner writeOfsurnameSc = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Write yours surname: ");
        String surname = writeOfsurnameSc.nextLine();
        System.out.println("Yours surname: " + surname);
        PrintWriter zapisOne = new PrintWriter("dane.txt");
        zapisOne.println("Surname: " + surname);
        zapisOne.close();


    }

    public static void isMaleorFamle() throws FileNotFoundException {
        Scanner isMaleorFamle = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Choice yours Gender (F/M): ");
        String isMaleorFamleSc = isMaleorFamle.nextLine();
        if (isMaleorFamleSc.equalsIgnoreCase("F")) {
            System.out.println("Famle");
            System.out.println("****************************");
        } else if (isMaleorFamleSc.equalsIgnoreCase("M")) {
            System.out.println("Male");
            System.out.println("****************************");
        }
        PrintWriter zapisTwo = new PrintWriter("dane.txt");
        zapisTwo.println(isMaleorFamleSc);
        zapisTwo.close();


    }

    public static void writeEmail() throws FileNotFoundException {
        Scanner emailSc = new Scanner(System.in);
        System.out.println("Write your e-mail (only first part): ");
        String write = emailSc.nextLine();
        System.out.println("Your e-mail: " + write + "@gmail.com");
        System.out.println("**********************");
        PrintWriter zapisThree = new PrintWriter("dane.txt");
        zapisThree.println(write);
        zapisThree.close();

    }


}