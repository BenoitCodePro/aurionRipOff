package com.crysteo;

import java.util.Scanner;

/**
 * Created by plesur on 10/17/15.
 * This class simply reads the user input til we know what he wants exactly.
 * We then call the corresponding CommandExecutor method with the rest of the parameters as a scanner object.
 * Error message are displayed as needed.
 */
public class InputParser {

    CommandExecutor commandExecutor;

    public InputParser() {
        commandExecutor = new CommandExecutor();
    }

    /**
     * Stat the core of the program, which is to read the user's inputs then react
     * @param userInput the line sent by the user
     */
    public void parse(String userInput) {
        Scanner line = new Scanner(userInput);
        if(line.hasNext()) {
            switch (line.next()) {
                case "help":
                    help(line);
                    break;
                case "delete":
                    break;
                case "add":
                    add(line);
                    break;
                case "serialize":
                    commandExecutor.serialize(line);
                    break;
                case "deserialize":
                    commandExecutor.deserialize(line);
                    break;
                case "display":
                    commandExecutor.displayAll();
                    break;
                default:
                    System.out.print("Unknown command. Please try again, or type \"help\" for more information.\n");
                    break;
            }
        }
    }

    /**
     * This function is called if the user wish to use the "add" function. It then redirect to the correct addPerson function of the CommandExecutor object.
     * @param line the scanner containing the user's command. Note that the scanner already points at the second value (first one is "add" and it has been read)
     */
    void add(Scanner line) {
        if(line.hasNext()) {
            String typeOfAdd = line.next();
            switch (typeOfAdd) {
                case "teacher":
                    //commandExecutor.addTeacher(line);
                    break;
                case "student":
                    commandExecutor.addStudent(line);
                    break;
                default:
                    Constants.wrong_command_usage();
                    break;
            }
        } else {
            Constants.wrong_command_usage();
        }
    }

    /**
     * Is called when we parsed the word "help" as a command. Take the rest of the user input as a parameter to choose which help to display.
     *
     * @param line the scanner containing the rest of the user input
     */
    void help(Scanner line) {
        if (line.hasNext()) {
            String helpAsked = line.next();
            switch (helpAsked) {
                case "add":
                    Constants.help_add();
                    break;
                case "serialize":
                    Constants.help_serialize();
                    break;
                default:
                    Constants.help_main();
                    break;
            }
        } else {
            Constants.help_main();
        }
    }

}
