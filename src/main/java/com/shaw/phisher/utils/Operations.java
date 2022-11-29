package com.shaw.phisher.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Operations {
    public static String activeFilePath = System.getProperty("user.home") + "/.phisher/.active";

    public static void writeFile(String path, String data){
        File file = new File(System.getProperty("user.home") + "/.phisher");
        file.mkdirs();
        try {
            File myObj = new File(path);
            if (!myObj.createNewFile()) {
                try {
                    FileWriter myWriter = new FileWriter(path);
                    myWriter.write(data);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }else {
                try {
                    FileWriter myWriter = new FileWriter(path);
                    myWriter.write(data);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeActiveFile(String option) {
        writeFile(activeFilePath, option);
    }

    public static String readActiveFile() {
        try {
            File myObj = new File(System.getProperty("user.home") + "/.phisher/.active");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
