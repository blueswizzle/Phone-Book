package com.company;

import resources.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
            UserInterface ui = new UserInterface();
            ui.readPhoneBookFile();
            ui.printNumbers();


    }
}