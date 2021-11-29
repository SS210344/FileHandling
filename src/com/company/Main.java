package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static File myObj = new File("NewFilename.txt"); //Change to something sensible
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CreateFile();

        ArrayList<String> userList = new ArrayList<>();
        userList=getUserList();

        WriteToFile(userList);

        ReadFile();

        System.out.println("Do you want to delete this file now Y or N?");
        String userOption = scanner.next();
        if (userOption.equals("Y")) {
            DeleteFile();
        }
    }

    public static ArrayList<String> getUserList(){
        ArrayList<String> userList = new ArrayList<>();
        System.out.println("number of students");
        int studentNum = Integer.parseInt(userInput());
        for (int i = 0; i < studentNum; i++) {
            System.out.println("student name:");
            userList.add(userInput());
        }
        return userList;


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

    public static void WriteToFile(ArrayList<String> userList ) {
        try {
            FileWriter myWriter = new FileWriter(myObj.getName(), false); //True means append to file contents, False means overwrite
            System.out.println("This is the contents of the file:");
             // Overwrites everything in the file
            for (int i = 0; i < userList.toArray().length; i++) {
                String studentName = userList.get(i)+"\n";
                myWriter.write(studentName);

            }
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
                if (checkString(data)){
                    System.out.println(data);
                }


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

    public static String userInput() {
        Scanner input = new Scanner(System.in);
        String UserInput = "";

        try {
            UserInput = input.next();

        } catch (Exception e) {
            System.out.println("an error occurred " + e);

        }

        return (UserInput);
    }

    public static boolean checkString(String data){
        boolean letter = false;
        for (int i = 0; i < data.length(); i++) {
            if((data.charAt(i)== 'e')||(data.charAt(i)== 'u') ){
                letter=true;
                break;
            }

        }
        return letter;

    }


}


