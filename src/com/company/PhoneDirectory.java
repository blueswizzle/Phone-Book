package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneDirectory {
    private ArrayList<Person> peopleList;
    private HashMap<Long,String> peopleHashMap;
    private ResourceLoader rl;

    public PhoneDirectory(){
        peopleList = new ArrayList<>();
        peopleHashMap = new HashMap<>();
        rl = new ResourceLoader();
    }
    public void readPhoneBookFile() throws FileNotFoundException {
        String folder = ResourceLoader.getResourceFolder();
        File file = new File(folder +"//phonenumbers");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String parts [] = sc.nextLine().split(" ");
            String firstName = parts[1];
            String lastName;
            Long number = Long.valueOf(parts[0]);
            /*if(parts.length !=3){
                name = parts[1] + " N/A";
            }else{
                name = parts[1] + " " + parts[2];
            }
            peopleHashMap.put(number,name);*/
            if(parts.length < 3){
                lastName = "N/A";
            }else{
                lastName = parts[2];
            }
            peopleList.add(new Person(firstName,lastName,number));
        }




    }
    public void printPeople(){
        for(Person person : peopleList){
            System.out.println(person);
        }
    }
    public void printPeopleHashMap(){
        peopleHashMap.entrySet().forEach( entry ->
                System.out.println(entry.getKey() + " -- " + entry.getValue()));
    }


}
