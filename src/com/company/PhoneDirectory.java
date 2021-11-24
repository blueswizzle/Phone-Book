package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneDirectory {
    private ArrayList<Person> peopleList;
    private Map<String, Set<Person>> firstNameMap;
    private Map<String, Set<Person>> lastNameMap;
    private Map<String, Set<Person>> phoneNumberMap;
    private ResourceLoader rl;

    public PhoneDirectory(){
        peopleList = new ArrayList<>();
        firstNameMap = new HashMap<>();
        lastNameMap = new HashMap<>();
        phoneNumberMap = new HashMap<>();
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
        Set<Person> set
                = firstNameMap.computeIfAbsent(person.getFirstName().toUpperCase(), k -> new HashSet<>());
        set.add(person);
        set = lastNameMap.computeIfAbsent(person.getLastName().toUpperCase(), k -> new HashSet<>());
        set.add(person);
        set = phoneNumberMap.computeIfAbsent(person.getPhoneNumber(), k -> new HashSet<>());
        set.add(person);
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
}
