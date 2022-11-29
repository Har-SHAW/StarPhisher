package com.shaw.phisher.utils;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Operations {
    public static String activeFilePath = System.getProperty("user.home") + "/.phisher/.active";

    public static void setup() {
        File file = new File(System.getProperty("user.home") + "/.phisher");
        file.mkdirs();

        if (!(new File(System.getProperty("user.home") + "/.phisher/pagekite.py")).exists()) {
            System.out.println("Starting Initial Setup");
            System.out.println("Downloading pagekite.py ...");
            try (BufferedInputStream in = new BufferedInputStream(new URL("https://pagekite.net/pk/pagekite.py").openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.home") + "/.phisher/pagekite.py")) {
                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println("Please check you internet connection!");
            }
        }
    }

    public static void writeFile(String path, String data) {
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                boolean file = myObj.createNewFile();
            }
            try {
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(data);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing a file.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating a file.");
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
