package com.crysteo.Data;

import com.crysteo.Data.Persons.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * contains data about a specific lesson: name, room, who attends this class (teachers + students) and date/hour
 * TODO add support for date/time
 * Created by plesur on 10/30/15.
 */
public class Lesson implements Serializable, Displayable {
    private String topicName;
    private String roomName;
    private ArrayList<Person> persons;

    public Lesson(String topicName_, String roomName_) {
        topicName = topicName_;
        roomName = roomName_;
    }

    private boolean checkForDuplicates(Person person) {
        for (Person person_ : persons) {
            if (person.getFirstName().equals(person_.getFirstName()) && person.getSurname().equals(person_.getSurname())) {
                return true;
            }
        }
        return false;
    }

    public boolean addPerson(Person person) {
        if (checkForDuplicates(person)) {
            return false;
        } else {
            persons.add(person);
            return true;
        }
    }

    /**
     * TODO test if that actually works
     *
     * @param person
     */
    public void deletePerson(Person person) {
        persons.remove(person);
    }

    public void displayInfo() {
        System.out.print("\nLesson topic: " + topicName +
                "\nRoom: " + roomName + "\n");
    }
}
