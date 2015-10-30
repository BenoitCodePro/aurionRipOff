package com.crysteo.Data;

import com.crysteo.Data.Persons.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * a simple wrapping class that makes serializing easier, although we can't separate lessons from persons
 * Created by plesur on 10/30/15.
 */
public class SerializingWrapper implements Serializable {
    private ArrayList<Person> persons;
    private ArrayList<Lesson> lessons;

    public SerializingWrapper() {
        persons = new ArrayList<>();
        lessons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

}
