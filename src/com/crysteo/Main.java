package com.crysteo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InputParser inputParser = new InputParser();
        Scanner scanner = new Scanner(System.in);
        Constants.present_software();
        Constants.new_line();
        while(scanner.hasNextLine()) {
            inputParser.parse(scanner.nextLine());
            Constants.new_line();
        }
    }
}
