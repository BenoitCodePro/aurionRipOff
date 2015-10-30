package com.crysteo;

import com.crysteo.Data.Lesson;
import com.crysteo.Data.Persons.Person;
import com.crysteo.Data.Persons.Student;
import com.crysteo.Data.Persons.Teacher;
import com.crysteo.Data.SerializingWrapper;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by plesur on 10/17/15.
 * This class is used to execute the command parsed by inputParser class. It still read parameter but it won't check them, only create new objects thanks to them.
 * There are still try/catch in case of an user input error.
 * All the important data are encapsulated inside this class because no one else needs to access them anyway.
 */
public class CommandExecutor {

    private SerializingWrapper serializingWrapper;

    public CommandExecutor() {
        serializingWrapper = new SerializingWrapper();
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
                (new ObjectOutputStream(fileStream)).writeObject(serializingWrapper);
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
                serializingWrapper = (SerializingWrapper) (new ObjectInputStream(fileStream)).readObject();
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
     * @param scanner the main scanner used for the inputs. We need to use it directly otherwise the main scanner still has the user inputs which would make no sense
     */
    public void addStudent(Scanner scanner) {
        String firstName = "placeholder";
        String surname = "placeholder";
        int promotion = -1;
        String rfidId = "placeholder";

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    System.out.print("\nFirst name:");
                    if (scanner.hasNext()) {
                        firstName = scanner.next();
                    }
                    break;
                case 1:
                    System.out.print("Surname:");
                    if (scanner.hasNext()) {
                        surname = scanner.next();
                    }
                    break;
                case 2:
                    System.out.print("Promotion:");
                    if (scanner.hasNext()) {
                        promotion = Integer.parseInt(scanner.next());
                    }
                    break;
                case 3:
                    System.out.print("RFID ID:");
                    if (scanner.hasNext()) {
                        rfidId = scanner.next();
                        scanner.nextLine();
                    }
                    break;
            }
        }
        serializingWrapper.getPersons().add(new Student(firstName, surname, promotion, rfidId));
    }

    /**
     * function to add a teacher to the arrayList of persons. It use a try/catch because there are no more options from the user, only data
     * @param scanner the main scanner used for the inputs. We need to use it directly otherwise the main scanner still has the user inputs which would make no sense
     */
    public void addTeacher(Scanner scanner) {
        String firstName = "placeholder";
        String surname = "placeholder";
        String officeRoom = "placeholder";
        String rfidId = "placeholder";

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    System.out.print("\nFirst name:");
                    if (scanner.hasNext()) {
                        firstName = scanner.next();
                    }
                    break;
                case 1:
                    System.out.print("Surname:");
                    if (scanner.hasNext()) {
                        surname = scanner.next();
                    }
                    break;
                case 2:
                    System.out.print("Promotion:");
                    if (scanner.hasNext()) {
                        officeRoom = scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("RFID ID:");
                    if (scanner.hasNext()) {
                        rfidId = scanner.next();
                        scanner.nextLine();
                    }
                    break;
            }
        }
        serializingWrapper.getPersons().add(new Teacher(firstName, surname, officeRoom, rfidId));
    }

    /**
     * simply calls all the displayInfo() method of all objects
     */
    public void displayAll() {
        for (Person person : serializingWrapper.getPersons()) {
            person.displayInfo();
        }
        for (Lesson lesson : serializingWrapper.getLessons()) {
            lesson.displayInfo();
        }
    }

    /**
     * TODO update with scanner and not line
     *
     * @param line
     */
    public void addLesson(Scanner line) {
        try {
            String topicName = line.next();
            String roomName = line.next();
            serializingWrapper.getLessons().add(new Lesson(topicName, roomName));
        } catch (NoSuchElementException e) {
            Constants.wrong_command_usage();
        }
    }
}
