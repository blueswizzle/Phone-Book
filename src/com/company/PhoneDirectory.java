package com.company;

import resources.ResourceLoader;

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
        firstNameMap = new HashMap<>();
        lastNameMap = new HashMap<>();
        phoneNumberMap = new HashMap<>();
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
    public Set<Person> getByFirstName(String firstname){
        return firstNameMap.get(firstname.toUpperCase());
    }
    public Set<Person> getByLastName(String lastname){
        return lastNameMap.get(lastname.toUpperCase());
    }
    public Set<Person> getByPhoneNumber(String number){
        return phoneNumberMap.get(number);
    }

    public void printAllPeopleByFirst() {
        firstNameMap.forEach((key, value) ->
                System.out.println("First name: " + key + " --- " + value));
    }
    public void printAllPeopleByLast(){
        lastNameMap.forEach((key, value) ->
                System.out.println("Last name: " + key + " --- " + value));
    }
}
