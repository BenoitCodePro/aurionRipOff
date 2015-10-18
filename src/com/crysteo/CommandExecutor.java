package com.crysteo;

import com.crysteo.Persons.Person;
import com.crysteo.Persons.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by plesur on 10/17/15.
 * This class is used to execute the command parsed by inputParser class. It still read parameter but it won't check them, only create new objects thanks to them.
 * There are still try/catch in case of an user input error.
 * All the important data are encapsulated inside this class because no one else needs to access them anyway.
 */
public class CommandExecutor {

    ArrayList<Person> entities;

        public CommandExecutor() {
            entities = new ArrayList<>();
        }

    /**
     * Write (serialize) to the file's path from the given scanner argument
     * We serialize the list of persons only (as of now)
     *
     * @param line scanner which is already at the 2nd element ("serialize" is the first). It only reads the first token and use it as a file path.
     */
    void serialize(Scanner line) {
        if(line.hasNext()) {
            String filePath = line.next();
            try {
                FileOutputStream fileStream = new FileOutputStream(filePath);
                (new ObjectOutputStream(fileStream)).writeObject(entities);
                fileStream.close();
            } catch (IOException e) {
                System.out.print("Problem serializing to the file.\n" +
                        "Error:\n" + e.toString() + "\n");
            }

        } else {
            Constants.wrong_command_usage();
        }
    }

    /**
     * Read (deserialize) the file's path from the given scanner argument
     * We deserialize the list of persons only (as of now).
     * We suppress the warning "unchecked cast" because there is no good way to do a clean cast anyway.
     *
     * @param line scanner which is already at the 2nd element ("deserialize" is the first). It only reads the first token and use it as a file path.
     */
    @SuppressWarnings("unchecked")
    void deserialize(Scanner line) {
        if(line.hasNext()) {
            String filePath = line.next();
            try {
                FileInputStream fileStream = new FileInputStream(filePath);
                entities = (ArrayList<Person>) (new ObjectInputStream(fileStream)).readObject();
                fileStream.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.print("Problem serializing from the file.\n" +
                        "Error:\n" + e.toString() + "\n");
            }
        } else {
            Constants.wrong_command_usage();
        }
    }


    /**
     * function to add a student to the arrayList of persons. It use a try/catch because there are no more options from the user, only data
     * @param line the rest of the user's input. Once again, it starts at the 2nd value (first two ones being "add student")
     */
    public void addStudent(Scanner line) {
        try {
            String firstName = line.next();
            String surName = line.next();
            int promotion = Integer.parseInt(line.next());
            entities.add(new Student(firstName,surName,promotion));
        } catch (NoSuchElementException e) {
            Constants.wrong_command_usage();
        }
    }

    /**
     * simply calls all the display function of all existing persons
     */
    public void displayAll() {
        for(Person person : entities) {
            person.display();
        }
    }
}
