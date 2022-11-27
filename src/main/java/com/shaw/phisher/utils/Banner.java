package com.shaw.phisher.utils;

public class Banner {
    public static void printBanner() {
        System.out.println(
                "\u001b[38;5;45m \u001b[1m \n\n" +
                        "  _________  __                      __________ .__     .__         .__                     \n" +
                        " /   _____/_/  |_ _____  _______     \\______   \\|  |__  |__|  ______|  |__    ____ _______  \n" +
                        " \\_____  \\ \\   __\\\\__  \\ \\_  __ \\     |     ___/|  |  \\ |  | /  ___/|  |  \\ _/ __ \\\\_  __ \\ \n" +
                        " /        \\ |  |   / __ \\_|  | \\/     |    |    |   Y  \\|  | \\___ \\ |   Y  \\\\  ___/ |  | \\/ \n" +
                        "/_______  / |__|  (____  /|__|        |____|    |___|  /|__|/____  >|___|  / \\___  >|__|    \n" +
                        "        \\/             \\/                            \\/          \\/      \\/      \\/         " +
                        "\u001B[0m \n" +
                        "\u001b[38;5;196m \u001b[1m" + "                                                 Version: \u001b[1m 1.0.0" + "\u001B[0m \n" +
                        "\u001b[38;5;196m \u001b[1m" + "                                                 Authors: \u001b[1m Harsha, Keerthi, Rahul, Nikhila" + "\u001B[0m"
        );
    }

    public static void printOptions() {
        int counter = 1;
        System.out.println("\u001b[38;5;220m"+"\n Please Select one from the below options.\n");
        for (String option : Constants.options) {
            System.out.printf("\u001b[38;5;220m"+"%" + 2 + "s", counter++);
            System.out.print(". " + "\u001b[38;5;201m"+String.format("%-" + 15 + "s", option) + "\t");
            if ((counter - 1) % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }
}
