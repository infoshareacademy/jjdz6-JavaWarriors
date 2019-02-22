package com.infoshareacademy;
import java.io.*;
import java.util.Scanner;

public class Person {

    public  String getName() {
        return name;
    }

    public void setName(){
        Scanner writeOfnameSc = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Write yours name: ");
        name = writeOfnameSc.nextLine();
        System.out.println("Yours name: " + name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname() {
        Scanner writeOfsurnameSc = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Write yours surname: ");
        surname = writeOfsurnameSc.nextLine();
        System.out.println("Yours surname: " + surname);
    }
    public String getGender() {
        return gender;
    }

    public void setGender() {
        Scanner isMaleorFamle = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("Choice yours Gender (F/M): ");
        gender = isMaleorFamle.nextLine();
        if (gender.equalsIgnoreCase("F")) {
            System.out.println("Famle");
            System.out.println("****************************");
        } else if (gender.equalsIgnoreCase("M")) {
            System.out.println("Male");
            System.out.println("****************************");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        Scanner emailSc = new Scanner(System.in);
        System.out.println("Write your e-mail (only first part): ");
        email = emailSc.nextLine();
        System.out.println("Your e-mail: " + email);
        System.out.println("**********************");
    }

    public void saveOnDisk() throws IOException {
       FileWriter fileWriter = new FileWriter("dane.txt");
       fileWriter.write(name);
       fileWriter.write(surname);
       fileWriter.write(email);
       fileWriter.write(gender);
       fileWriter.close();
    }


    private  String name;
    private  String surname;
    private  String gender;
    private  String email;


}