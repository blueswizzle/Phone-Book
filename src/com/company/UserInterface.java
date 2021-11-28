package com.company;

import java.io.FileNotFoundException;
import java.util.Locale;
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
            case "0" -> System.exit(0);
        }
    }
    public void phoneDirectoryDatabase() throws FileNotFoundException {
        PhoneDirectory pd = new PhoneDirectory();
        pd.readPhoneBookFile();
        while(true){
            printPhoneDatabaseOptions();
            String input = scanner.nextLine();
            switch(input){
                case "5": start();
                case "1":
                    System.out.println("----------------------");
                    System.out.println("Enter full first name [Case insensitive]");
                    String name = scanner.nextLine();
                    System.out.println("Showing all " + name.toUpperCase(Locale.ROOT));
                    pd.getByFirstName(name);
                    continue;
                case "2":
                    System.out.println("----------------------");
                    System.out.println("Enter full last name [Case insensitive]");
                    String lastName = scanner.nextLine();
                    System.out.println("Showing all " + lastName.toUpperCase(Locale.ROOT));
                    pd.getByLastName(lastName);
                    continue;
                case "3":
                    System.out.println("----------------------");
                    System.out.println("Enter phone number");
                    String number = scanner.nextLine();
                    System.out.println("Showing all " + number);
                    pd.getByPhoneNumber(number);
                    continue;
                case "4":
                    System.out.println("----------------------");
                    System.out.println("1.By first name\n2.By last name\n3.By phone number");
                    String choice = scanner.nextLine();
                    switch(choice){
                        case "1": pd.printAllByFirst();continue;
                        case "2": pd.printAllByLast();continue;
                        case "3": pd.printAllByPhoneNumber();continue;
                }

            }
            break;
        }


    }
    public void printPhoneDatabaseOptions(){
        System.out.println("-------------------------------------------------");
        System.out.println("What would you like to do?\n1.Search by first name\n2.Search by last name\n3.Search by phone number" +
                "\n4.Print Contacts\n5.Exit");
    }
}
