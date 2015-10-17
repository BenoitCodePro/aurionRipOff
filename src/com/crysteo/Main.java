package com.crysteo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InputParser inputParser = new InputParser();
        Scanner scanner = new Scanner(System.in);



        System.out.print("Welcome to Aurion Rip-Off !\n" +
                "Please use on of the following command (type help command for more information).\n" +
                "You can exit this program with the EOF char (^D).\n\n");
        while(scanner.hasNextLine()) {
            inputParser.parse(scanner.nextLine());
        }

    }
}
