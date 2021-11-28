package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class PhoneDirectory {
    private Map<String, Set<Person>> firstNameMap;
    private Map<String, Set<Person>> lastNameMap;
    private Map<String, Set<Person>> phoneNumberMap;
    private static final Path DEFAULT_PHONE_BOOK_PATH = Path.of(System.getProperty("user.dir"),"Phone Numbers List");

    public PhoneDirectory(){
        firstNameMap = new TreeMap<>();
        lastNameMap = new TreeMap<>();
        phoneNumberMap = new TreeMap<>();
    }
    public void readPhoneBookFile() throws FileNotFoundException {
        File file = new File(DEFAULT_PHONE_BOOK_PATH +"//phonenumbers");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String parts [] = sc.nextLine().split(" ");
            String firstName = parts[1];
            String lastName;
            String number = parts[0];
            if(parts.length < 3){
                lastName = "N/A";
            }else{
                lastName = parts[2];
            }
            addPerson(new Person(firstName,lastName,number));
        }
    }
    public void addPerson(Person person){
        firstNameMap.computeIfAbsent(person.firstName().toUpperCase(Locale.ROOT), k -> new HashSet<>())
                .add(person);
        lastNameMap.computeIfAbsent(person.lastName().toUpperCase(Locale.ROOT), k -> new HashSet<>())
                .add(person);
        phoneNumberMap.computeIfAbsent(person.phoneNumber(), k -> new HashSet<>())
                .add(person);

    }
    public void getByFirstName(String name) {
        Map<String, Set<Person>> result = new TreeMap<>();
        for (String s : firstNameMap.keySet()) {
            if (s.startsWith(name.toUpperCase(Locale.ROOT))) {
                result.put(s, firstNameMap.get(s));
            }
        }
        result.forEach((key, value) -> {
            System.out.println("First name: " + key + " --- " + value);
        });
        result.clear();
    }
    public void getByLastName(String lastname){
        Map<String,Set<Person>> result = new TreeMap<>();
        for(String s : lastNameMap.keySet()){
            if(s.startsWith(lastname.toUpperCase(Locale.ROOT))){
                result.put(s,lastNameMap.get(s));
            }
        }
        result.forEach((key,value) ->{
            System.out.println("Last name: " + key + " --- " + value);
        });
        result.clear();
    }
    public void getByPhoneNumber(String number){
        Map<String,Set<Person>> result = new TreeMap<>();
        for(String s : phoneNumberMap.keySet()){
            if(s.startsWith(number)){
                result.put(s,phoneNumberMap.get(s));
            }
        }
        result.forEach((key,value) ->{
            System.out.println("Number: " + key + " --- " + value);
        });
        result.clear();
    }

    public void printAllByFirst() {
        firstNameMap.forEach((key,value) ->{
            System.out.println("First name: " + key + " --- " + value);
        });
    }
    public void printAllByLast(){
        lastNameMap.forEach((k,v) ->{
            System.out.println("First name: " + k + " --- " + v);
        });
    }
    public void printAllByPhoneNumber(){
        phoneNumberMap.forEach((k, v) ->{
            System.out.println("Number: " + k + " --- " + v);
        });
    }
}
