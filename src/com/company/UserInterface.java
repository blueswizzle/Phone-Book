package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    ArrayList<Long> phoneNumbers;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        phoneNumbers = new ArrayList<>();
    }

    public void start(){



    }
    public void readPhoneBookFile() throws FileNotFoundException {
        String folder = ResourceLoader.getResourceFolder();
        File file = new File(folder +"\\phonenumbers" );
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String parts [] = sc.nextLine().split(" ");
            Long number = Long.valueOf(parts[0]);
            phoneNumbers.add(number);
        }




    }
    public void printNumbers(){
        for(Long number : phoneNumbers){
            System.out.println(number);
        }
    }
    public void listFiles(){

    }


}
