package com.infoshareacademy;

import java.util.Scanner;

public class Person {

    public String name;
    public String surname;
    public String gender;
    public Integer age;

    public static void writeOfname() {
        ;
        Scanner writeOfnameSc = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("Write yours name: ");
        String name = writeOfnameSc.nextLine();
        System.out.println("Yours name: " + name);
    }

    public static void writeOfsurname() {
        Scanner writeOfsurnameSc = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("Write yours surname: ");
        String name = writeOfsurnameSc.nextLine();
        System.out.println("Yours surname: " + name);
    }

    public static void isMaleorFamle() {
        Scanner isMaleorFamle = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("Choice yours Gender (F/M): ");
        String isMaleorFamleSc = isMaleorFamle.nextLine();
        if (isMaleorFamleSc.equalsIgnoreCase("F")) {
            System.out.println("Famle");
            System.out.println("**********************");
        } else if (isMaleorFamleSc.equalsIgnoreCase("M")) {
            System.out.println("Male");
            System.out.println("**********************");

        }

    }

    public static void writeEmail() {
        Scanner emailSc = new Scanner(System.in);
        System.out.println("Write your e-mail (only first part): ");
        String write = emailSc.nextLine();
        System.out.println("Your e-mail: " + write + "@gmail.com");
        System.out.println("**********************");
    }
}