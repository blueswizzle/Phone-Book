package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneDirectory {
    private ArrayList<Long> phoneNumbers;
    private HashMap<Long,String> peopleList; //This holds the phone number and the associated person as Key-Value pairs.
    private ResourceLoader rl;

    public PhoneDirectory(){
        phoneNumbers = new ArrayList<>();
        peopleList = new HashMap<>();
        rl = new ResourceLoader();
    }
    public void readPhoneBookFile() throws FileNotFoundException {
        String folder = ResourceLoader.getResourceFolder();
        File file = new File(folder +"//phonenumbers");
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


}
