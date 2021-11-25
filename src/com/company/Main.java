package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PhoneDirectory pd = new PhoneDirectory();
        pd.readPhoneBookFile();
        pd.printAllPeopleByFirst();



    }
}
