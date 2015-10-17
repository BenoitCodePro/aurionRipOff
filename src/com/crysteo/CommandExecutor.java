package com.crysteo;

import com.crysteo.Persons.Person;
import com.crysteo.Persons.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by plesur on 10/17/15.
 */
public class CommandExecutor {

    ArrayList<Person> entities;

        public CommandExecutor() {
            entities = new ArrayList<Person>();
        }

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
            System.out.print(InputParser.WRONG_COMMAND);
        }
    }

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
            System.out.print(InputParser.WRONG_COMMAND);
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
            System.out.print(InputParser.WRONG_COMMAND);
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
