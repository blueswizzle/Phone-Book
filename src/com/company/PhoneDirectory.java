package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneDirectory {
    private ArrayList<Person> peopleList;
    private HashMap<String,Long> peopleHashMap;
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
            String name;
            String firstName = parts[1];
            String lastName;
            Long number = Long.valueOf(parts[0]);
            if(parts.length !=3){
                name = parts[1] + " N/A";
            }else{
                name = parts[1] + " " + parts[2];
            }
            peopleHashMap.put(name,number);
            if(parts.length < 3){
                lastName = "N/A";
            }else{
                lastName = parts[2];
            }
            peopleList.add(new Person(firstName,lastName,number));
        }
    }
    public void getNumber(String firstName){
        for (Person person : peopleList) {
            if (person.getFirstName().toLowerCase().equals(firstName.toLowerCase(Locale.ROOT))) {
                person.getPhoneNumber();
                break;
            }
        }
    }
    public void printPeople(){
        for(Person person : peopleList){
            System.out.println(person);
        }
    }
    public void sortByFirstName(){
        peopleList.sort(Comparator.comparing(Person::getFirstName));
    }
    public void sortByLastName(){
        peopleList.sort(Comparator.comparing(Person::getLastName).reversed());
    }

    public void printPeopleByFirstName(){
        sortByFirstName();
        for(Person p : peopleList){
            System.out.println(p);
        }
    }
    public void printPeopleByLastName(){
        sortByLastName();
        for(Person p : peopleList){
            System.out.println(p);
        }
    }
    public void printPeopleHashMap(){
        peopleHashMap.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " -- " + entry.getValue()));
    }


}
