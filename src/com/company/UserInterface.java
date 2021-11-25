package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;


    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws FileNotFoundException {
        System.out.println("Welcome to the Main Menu! Which database would you like to access? Enter 0 to end.");
        listFiles();
        chooseDatabase();
    }
    public void listFiles(){
        System.out.println("Files:\n1. phonenumbers.txt");
    }
    public void chooseDatabase() throws FileNotFoundException {
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> phoneDirectoryDatabase();
        }
    }
    public void phoneDirectoryDatabase() throws FileNotFoundException {
        PhoneDirectory pd = new PhoneDirectory();
        pd.readPhoneBookFile();
        while(true){
            printPhoneDatabaseOptions();
            String input = scanner.nextLine();
            switch(input){
                case "5": break;
                case "1":
                    System.out.println("Enter first name [Case insensitive]");
                    System.out.println(pd.getByFirstName(scanner.nextLine()));

            }
            break;
        }
        System.out.println();
        start();
    }
    public void printPhoneDatabaseOptions(){
        System.out.println("-------------------------------------------------");
        System.out.println("What would you like to do?\n1.Search by first name\n2.Search by last name\n3.Search by phone number" +
                "\n4.Print Contacts\n5.Exit");
    }
}
