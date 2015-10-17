package com.crysteo;

import java.util.Scanner;

/**
 * Created by plesur on 10/17/15.
 */
public class InputParser {

    final static String WRONG_COMMAND = "Wrong usage of the command. Please see the help function.\n";
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
        String command;

        if(line.hasNext()) {
            switch ((command = line.next())) {
                case "help":
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
                    System.out.print(WRONG_COMMAND);
                    break;
            }
        } else {
            System.out.print(WRONG_COMMAND);
        }
    }

}
