package com.crysteo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser(scanner);
        Constants.present_software();
        Constants.new_line();
        while(scanner.hasNextLine()) {
            inputParser.parse();
            Constants.new_line();
        }
    }
}
