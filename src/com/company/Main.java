package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static File myObj = new File("NewFilename.txt"); //Change to something sensible
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CreateFile();

        WriteToFile();

        ReadFile();

        System.out.println("Do you want to delete this file now Y or N?");
        String userOption = scanner.next();
        if (userOption.equals("Y")) {
            DeleteFile();
        }
    }

    public static void CreateFile() {
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter(myObj.getName(), true); //True means append to file contents, False means overwrite
            System.out.println("This is the contents of the file:");
            myWriter.write("Files in Java might be tricky, but it is fun enough!"); // Overwrites everything in the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void ReadFile() {
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void DeleteFile() {
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}


